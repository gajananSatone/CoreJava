package org.threading.variables;

import java.util.concurrent.TimeUnit;

public class Core {
	public static void main(String[] args) {
		UnsafeTask task=new UnsafeTask();
		
		for (int i=0; i<10; i++){
			Thread thread=new Thread(task);
			thread.start();
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

//Thread Finished: 8  : Sat Jul 09 15:38:31 IST 2016
//Thread Finished: 9  : Sat Jul 09 15:38:31 IST 2016
//Thread Finished: 13 : Sat Jul 09 15:38:45 IST 2016
//Thread Finished: 15 : Sat Jul 09 15:38:45 IST 2016
//Thread Finished: 16 : Sat Jul 09 15:38:45 IST 2016
//Thread Finished: 17 : Sat Jul 09 15:38:45 IST 2016
//Thread Finished: 14 : Sat Jul 09 15:38:39 IST 2016
//Thread Finished: 11 : Sat Jul 09 15:38:37 IST 2016
