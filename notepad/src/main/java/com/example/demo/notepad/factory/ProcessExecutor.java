package com.example.demo.notepad.factory;

import org.springframework.stereotype.Component;

import com.example.demo.notepad.exception.NotePadException;

@Component
public interface ProcessExecutor {
	public String executeProcess(String userId) throws NotePadException;
}
