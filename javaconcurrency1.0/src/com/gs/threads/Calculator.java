package com.gs.threads;

public class Calculator implements Runnable {

	private int number;
	public Calculator(int number) {
		this.number = number;
	}

	@Override
	public void run() {
		for(int i = 0 ;i < 10 ; i++){
			System.out.printf("%s: %d * %d = %d\n",Thread.currentThread().getName(),number,i,i*number);
//			System.out.println("Context class loader " + Thread.currentThread().getContextClassLoader());
//			System.out.println("Stack trace "+ Thread.currentThread().getStackTrace());
//			System.out.println("UncaughtExceptionHandler "+ Thread.currentThread().getUncaughtExceptionHandler());					
		}
	
	}
}
