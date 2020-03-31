package com.example.demo.notepad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.notepad.exception.NotePadException;
import com.example.demo.notepad.factory.ProcessExecutor;
import com.example.demo.notepad.thread.NotePadThreadContainer;

@Service
public class ProcessStopperService implements ProcessExecutor {

	@Autowired
	private NotePadThreadContainer container;

	@Override
	public String executeProcess(String userId) throws NotePadException {
		try {
			System.out.println(container.getThreadContainer().size());
			if (container.getProcess(userId) != null) {
				container.getProcess(userId).destroy();
				container.removeProcess(userId);
			} else
				throw new NotePadException("There is no process running for the user: " + userId);
			System.out.println(container.getThreadContainer().size());
			return "Successfully Stopped the Process";
		} catch (Exception e) {
			throw new NotePadException("An exception Occured while stopping the process: " + e.getMessage());
		}
	}

}
