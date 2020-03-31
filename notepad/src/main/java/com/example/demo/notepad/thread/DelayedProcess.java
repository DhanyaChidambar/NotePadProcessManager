package com.example.demo.notepad.thread;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedProcess implements Delayed {

	private long time;
	private Process process;
	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public DelayedProcess(long time,Process process) {
			this.time=time;
			this.process=process;
	}
	

	@Override
	public int compareTo(Delayed obj) {
		if (this.time < ((DelayedProcess) obj).time) {
			return -1;
		}
		if (this.time > ((DelayedProcess) obj).time) {
			return 1;
		}
		return 0;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		long diff = time - System.currentTimeMillis();
		return unit.convert(diff, TimeUnit.MILLISECONDS);
	}

	public Process getProcess() {
		return process;
	}

	public void setProcess(Process process) {
		this.process = process;
	}

}
