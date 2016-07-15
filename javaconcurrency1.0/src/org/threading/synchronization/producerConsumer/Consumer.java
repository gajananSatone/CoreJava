package org.threading.synchronization.producerConsumer;

public class Consumer implements Runnable {
	private EventStorage storage;
	public Consumer(EventStorage storage){
		this.storage=storage;
	}
	@Override
	public void run() {
		for (int i=0; i<1000; i++){
			storage.get();
		}

	}
}
