package com.example.demo.notepad.thread;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.DelayQueue;

import org.springframework.stereotype.Component;

@Component
public class NotePadThreadContainer {

	private ConcurrentMap<String, Process> threadContainer = new ConcurrentHashMap<>();

	private DelayQueue<DelayedProcess> delayedQueue=new DelayQueue<>();
	public ConcurrentMap<String, Process> getThreadContainer() {
		return threadContainer;
	}

	public void setThreadContainer(ConcurrentMap<String, Process> filteredProcessMap) {
		this.threadContainer = filteredProcessMap;
	}
	
	public Process getProcess(String userId) {
		return this.threadContainer.get(userId);
	}
	public void addProcess(String userId,Process process) {
		this.threadContainer.put(userId,process);
	}
	public void removeProcess(String userId) {
		this.threadContainer.remove(userId);
	}

	public DelayQueue<DelayedProcess> getDelayedQueue() {
		return delayedQueue;
	}

	public void setDelayedQueue(DelayQueue<DelayedProcess> delayedQueue) {
		this.delayedQueue = delayedQueue;
	}
	
	public void removeExpiredProcess() {
		System.out.println("DQ before"+delayedQueue.size()+" "+delayedQueue.peek());
		
			DelayedProcess polledProcess = delayedQueue.poll();
		if(polledProcess!=null) {
			polledProcess.getProcess().destroy();
		}
		System.out.println("DQ after"+delayedQueue.size());
	}

	public void addProcessToDelayedQueue(DelayedProcess delayedProcess) {
		this.delayedQueue.add(delayedProcess);
		
	}
}
