package com.gs.RandD;

public class Task1 implements Runnable {

	Worker w = new Worker("Sunil", 35);	

	public Task1(){

		System.out.println("Task1 constructor");
	}

	@Override
	public void run() {
		System.out.println("Its task 1 runnable");
		w.doWork();
		
		synchronized (w) {
			w.notify();
 		}
		
//		try{
//			w.notify();
//		}
//		catch(IllegalMonitorStateException ie){
//			ie.printStackTrace();			
//		}
		
		System.out.println("Done with exception handaling");
	}


}
