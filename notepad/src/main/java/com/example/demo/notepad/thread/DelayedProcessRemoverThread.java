package com.example.demo.notepad.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DelayedProcessRemoverThread implements Runnable{

	@Autowired
	private NotePadThreadContainer container;
	
	@Override
	public void run() {
		while(true) {
			try {
				container.removeExpiredProcess();
				Thread.sleep(5000L);
			} catch (InterruptedException e) {
				System.out.println("Exception occured while modifying delayed queue");
			}
		}
	}	
}
