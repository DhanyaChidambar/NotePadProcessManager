package com.example.demo.notepad.factory;

import org.springframework.stereotype.Component;

@Component
public interface ProcessExecutorFactory {
public static ProcessExecutor getProcessExecutor(ProcessExecutorType action) {
	return action.getProcessExecutor();
}
}
