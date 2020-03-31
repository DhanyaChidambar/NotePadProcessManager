package com.example.demo.notepad.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.notepad.exception.NotePadException;
import com.example.demo.notepad.factory.ProcessExecutor;
import com.example.demo.notepad.factory.ProcessExecutorFactory;
import com.example.demo.notepad.factory.ProcessExecutorType;

@Controller
@RequestMapping("/notepad")
public class NotePadController {

	@GetMapping("/{userId}/{action}")
	public ResponseEntity<String> executeProcess(@PathVariable("userId") String userId,
			@PathVariable("action") String action) {
		ProcessExecutor processExecutor = ProcessExecutorFactory
				.getProcessExecutor(ProcessExecutorType.valueOf(action.toUpperCase()));
		ResponseEntity<String> responseEntity = null;
		try {
			String response = processExecutor.executeProcess(userId);
			responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
		} catch (NotePadException e) {
			responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

	@GetMapping("/killOrphanThreads")
	public ResponseEntity<String> killThreads(String userId) {
		ProcessExecutor processExecutor = ProcessExecutorFactory
				.getProcessExecutor(ProcessExecutorType.valueOf("KILLOPENPROCESS"));
		ResponseEntity<String> responseEntity = null;
		try {
			String response = processExecutor.executeProcess(userId);
			responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
		} catch (NotePadException e) {
			responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

}
