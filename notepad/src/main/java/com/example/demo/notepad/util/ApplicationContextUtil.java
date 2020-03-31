package com.example.demo.notepad.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextUtil implements ApplicationContextAware{

	private static ApplicationContext appContext;
	
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.appContext=context;
		
	}
	
	public static <T> T getBean(Class<T> c) {
		return appContext.getBean(c);
	}

}
