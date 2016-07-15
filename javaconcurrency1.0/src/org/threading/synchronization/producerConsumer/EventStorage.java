package org.threading.synchronization.producerConsumer;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class EventStorage {
	private int maxSize;
	private Queue<Date> storage;
	
	public EventStorage(){
		maxSize=4;
		storage=new LinkedList<>();
	}

	public synchronized void set(){
		while (storage.size()==maxSize){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		storage.offer(new Date());
		System.out.printf("Set: %d \n",storage.size());
		notifyAll();
	}

	public synchronized void get(){
		while (storage.size()==0){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("Get: %d: %s \n",storage.size(),((LinkedList<?>)storage).poll());
		notifyAll();
	}

	public int storageSize() {
		return storage.size();
	}
}
