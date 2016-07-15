package org.threading.synchronization.producerConsumer;

public class Main {
	public static void main(String[] args) {
		EventStorage storage=new EventStorage();
		Producer producer=new Producer(storage);
		Thread thread1=new Thread(producer);
		
		Producer producer1=new Producer(storage);
		Thread thread3=new Thread(producer1);
		
		Consumer consumer=new Consumer(storage);
		Thread thread2=new Thread(consumer);
		thread3.start();
		thread2.start();
		thread1.start();
	}
}
