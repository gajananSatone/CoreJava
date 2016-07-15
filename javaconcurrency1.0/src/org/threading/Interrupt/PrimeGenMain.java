package org.threading.Interrupt;

public class PrimeGenMain {
	public static void main(String[] args) {
		Thread task = new PrimeGenerator();
		task.start();
		try{
			Thread.sleep(5000);
		}catch (InterruptedException ie){
			ie.printStackTrace();
		}
		task.interrupt();
	}
}
