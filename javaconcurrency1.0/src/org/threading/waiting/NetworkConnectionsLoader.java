package org.threading.waiting;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class NetworkConnectionsLoader implements Runnable{

	@Override
	public void run() {
		System.out.printf("Beginning Network Connections loading: %s\n",new Date());
		try {
			TimeUnit.SECONDS.sleep(6);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Network Connections loading has finished:%s\n",new Date());
	}
}
