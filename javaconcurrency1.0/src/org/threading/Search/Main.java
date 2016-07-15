package org.threading.Search;

import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) {
		
		String inPath = args[0];
		
		if(inPath.isEmpty()){
			System.out.println("Input path is empty ");
			System.exit(0);
		}
		
		FileSearch search = new FileSearch("/home/gajanans/", "Mockito");
		Thread task = new Thread(search);
		task.start();
		
		try{
			TimeUnit.SECONDS.sleep(10);
		}catch (InterruptedException ie){
			ie.printStackTrace();
		}
		
		task.interrupt();

	}
}
