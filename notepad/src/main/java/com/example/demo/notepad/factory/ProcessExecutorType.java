package com.example.demo.notepad.factory;

import java.util.function.Supplier;

import com.example.demo.notepad.service.ProcessCleanerService;
import com.example.demo.notepad.service.ProcessStarterService;
import com.example.demo.notepad.service.ProcessStopperService;
import com.example.demo.notepad.service.TimerProcessService;
import com.example.demo.notepad.util.ApplicationContextUtil;

public enum ProcessExecutorType {

	START(()->ApplicationContextUtil.getBean(ProcessStarterService.class)),
	STOP(()->ApplicationContextUtil.getBean(ProcessStopperService.class)),
	KILLOPENPROCESS(()->ApplicationContextUtil.getBean(ProcessCleanerService.class)),
	TIMERPROCESS(()->ApplicationContextUtil.getBean(TimerProcessService.class));
	
	private Supplier<ProcessExecutor> executorSupplier;
	
	
	private ProcessExecutorType(Supplier<ProcessExecutor> supplier) {
		this.executorSupplier=supplier;
	}
	
	public ProcessExecutor getProcessExecutor() {
		return this.executorSupplier.get();
	}
}
