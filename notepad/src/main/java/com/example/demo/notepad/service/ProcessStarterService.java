package com.example.demo.notepad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.notepad.exception.NotePadException;
import com.example.demo.notepad.factory.ProcessExecutor;
import com.example.demo.notepad.thread.DelayedProcess;
import com.example.demo.notepad.thread.NotePadThreadContainer;

@Service
public class ProcessStarterService implements ProcessExecutor {

	
	@Autowired
	private NotePadThreadContainer container;
	
	@Override
	public String executeProcess( String userId) throws NotePadException {
		try {
		System.out.println("Before start"+container.getThreadContainer().size());
		if(container.getProcess(userId)!=null) {
			throw new NotePadException("There is already a notepad opened for the user "+userId);
		}
		ProcessBuilder builder=new ProcessBuilder("notepad");
		Process notePadProcess= builder.start();
		
		container.addProcess(userId, notePadProcess);
		DelayedProcess delayedProcess=new DelayedProcess(System.currentTimeMillis()+15000, notePadProcess);
		container.addProcessToDelayedQueue(delayedProcess);
		System.out.println("After start"+container.getThreadContainer().size()+" "+container.getDelayedQueue().size());
		return "Successfully Started the process";
		}catch(Exception e) {
			throw new NotePadException("Failed to start the process: "+e.getMessage());
		}
		
	}

}
