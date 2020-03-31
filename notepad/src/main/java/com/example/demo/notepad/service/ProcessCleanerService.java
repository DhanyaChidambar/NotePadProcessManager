package com.example.demo.notepad.service;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.notepad.exception.NotePadException;
import com.example.demo.notepad.factory.ProcessExecutor;
import com.example.demo.notepad.thread.NotePadThreadContainer;

@Service
public class ProcessCleanerService implements ProcessExecutor{

	@Autowired
	private NotePadThreadContainer container;
	
	@Override
	public String executeProcess(String userId) throws NotePadException {
		ConcurrentMap<String, Process> filteredProcessMap = container.getThreadContainer().entrySet().stream().filter(entry->entry.getValue().isAlive()).collect(Collectors.toConcurrentMap(Map.Entry::getKey, Map.Entry::getValue));
		container.setThreadContainer(filteredProcessMap);
		return "Successfull cleaned processes";
	}

}
