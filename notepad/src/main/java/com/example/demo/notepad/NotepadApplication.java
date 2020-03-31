package com.example.demo.notepad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.demo.notepad.exception.NotePadException;
import com.example.demo.notepad.factory.ProcessExecutor;
import com.example.demo.notepad.factory.ProcessExecutorFactory;
import com.example.demo.notepad.factory.ProcessExecutorType;

@Configuration
@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@ComponentScan( basePackages = {"com.example.demo.notepad"})

public class NotepadApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(NotepadApplication.class, args);
		System.out.println("Application Started");
		ProcessExecutor timerProcess = ProcessExecutorFactory.getProcessExecutor(ProcessExecutorType.TIMERPROCESS);
		try {
			timerProcess.executeProcess(null);
		} catch (NotePadException e) {
			
			System.out.println("Exception occured while starting the timerprocess "+e);
		}
	}

}
