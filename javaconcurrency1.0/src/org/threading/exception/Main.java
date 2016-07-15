package org.threading.exception;

import org.threading.Interrupt.PrimeGenerator;

public class Main {
	public static void main(String[] args) {
		Task task=new Task();
		
		Thread task1 = new PrimeGenerator();
		task1.start();
		
		try{
			Thread.sleep(1000);
		}catch (InterruptedException ie){
			ie.printStackTrace();
		}
		
		Thread thread=new Thread(task);
		thread.setName("worker");

		//		int numero=Integer.parseInt("TTT");		
		//		System.out.println("This is still runing afte exception");

		thread.setUncaughtExceptionHandler(new ExceptionHandler());
		thread.start();
	

		task1.interrupt();
	}
}
