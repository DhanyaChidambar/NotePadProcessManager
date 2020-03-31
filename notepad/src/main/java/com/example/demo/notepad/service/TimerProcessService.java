package com.example.demo.notepad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.notepad.exception.NotePadException;
import com.example.demo.notepad.factory.ProcessExecutor;
import com.example.demo.notepad.thread.DelayedProcessRemoverThread;

@Service
public class TimerProcessService implements ProcessExecutor{

	@Autowired
	private DelayedProcessRemoverThread processRemoverThread;
	@Override
	public String executeProcess(String userId) throws NotePadException {
		processRemoverThread.run();
		return null;
	}

	
}
