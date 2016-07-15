package org.threading.executors.delayFuture;

import java.util.Date;
public class Task implements Runnable {
	private String name;
	
	public Task(String name) {
		this.name=name;
	}

	public String call() throws Exception {
		System.out.printf("CALL %s: Starting at : %s\n",name,new Date());
		return "CALL Hello, world";
	}

	@Override
	public void run() {
		System.out.printf("%s: Starting at : %s\n",name,new Date());				
	}
}
