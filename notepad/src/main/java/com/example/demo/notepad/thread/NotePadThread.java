package com.example.demo.notepad.thread;

import java.io.IOException;

public class NotePadThread extends Thread{

	private boolean isAlive;
	private boolean isProcessRunning;
	
	@Override
	public void run() {
		Runtime runtime=Runtime.getRuntime();
		Process process=null;
		try {
			process = runtime.exec("notepad");
			System.out.println("inside run");
			isAlive=true;
			
			setProcessRunning(process.isAlive());
			while(isAlive) {
				setProcessRunning(process.isAlive());
				try {
					this.sleep(1000L);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}	
		} catch (IOException e) {
			System.out.println("Exception while starting notepad");
		}
		
		process.destroy();
		System.out.println("exiting run");
		System.out.println("this.isAlive() "+this.isAlive()+"daemon "+this.isDaemon()+"interrupt "+this.isInterrupted()); 
	}
	
	public void stopThread() {
		this.isAlive=false;
	}

	public boolean isProcessRunning() {
		return isProcessRunning;
	}

	public void setProcessRunning(boolean isProcessRunning) {
		this.isProcessRunning = isProcessRunning;
	}
}
