package com.gs.RandD;

public class MainTask {
	public static void main(String[] args) {
		Task1 R1 = new Task1();
//		Task2 R2 = new Task2();

		Thread T1 = new Thread(R1);
		Thread T2 = new Thread(R1);
		
		T1.start();
		T2.start();
	

	}
}
