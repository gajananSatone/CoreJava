package org.threading.exception;

public class Task implements Runnable {
	@SuppressWarnings("unused")
	@Override
	public void run() {
		int numero=Integer.parseInt("TTT");		
		System.out.println("This is still runing afte exception");
	}
}
