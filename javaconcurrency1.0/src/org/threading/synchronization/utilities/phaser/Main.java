package org.threading.synchronization.utilities.phaser;

import java.util.concurrent.Phaser;

public class Main {
	public static void main(String[] args) {
		Phaser phaser=new Phaser(3);
		
		FileSearch system=new FileSearch("/usr/local/hadoop/logs", "log",phaser);
		FileSearch apps= new FileSearch("/bin","log",phaser);
		FileSearch documents= new FileSearch("/home/gajanans/Downloads","log",phaser);

		Thread systemThread=new Thread(system,"System");
		systemThread.start();

		Thread appsThread=new Thread(apps,"Apps");
		appsThread.start();

		Thread documentsThread=new Thread(documents, "Documents");
		documentsThread.start();

		try {
			systemThread.join();
			appsThread.join();
			documentsThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Terminated: "+ phaser.isTerminated());
	}
}
