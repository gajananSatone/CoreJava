package org.threading.Demon;

//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.InputStream;
import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

public class WriterTask implements Runnable{

	private Deque<Event> deque;
	public WriterTask (Deque<Event> deque){
		this.deque=deque;
	}

	@Override
	public void run() {

//		File myFile = new File("Somefile");
//		File listArray [] = myFile.listFiles();
//
//		for (File file : listArray){
//			try{
//				InputStream in = new FileInputStream(file);
//			}catch (FileNotFoundException ex){
//				
//			}
//
//		}

		for (int i=1; i<100; i++) {
			Event event=new Event();
			event.setDate(new Date());
			event.setEvent(String.format("The thread %s has generated an event",Thread.currentThread().getId()));
			deque.addFirst(event);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
