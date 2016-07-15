package org.threading.synchronization.utilities.phaser;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class FileSearch implements Runnable {

	private String initPath;
	private String end;
	private List<String> results;
	private Phaser phaser;

	public FileSearch(String initPath, String end, Phaser phaser) {
		this.initPath = initPath;
		this.end = end;
		this.phaser=phaser;
		results=new ArrayList<>();
	}
	@Override
	public void run() {
		phaser.arriveAndAwaitAdvance();
		System.out.printf("%s: Starting.\n",Thread.currentThread().getName());
		File file = new File(initPath);
		if (file.isDirectory()) {
			directoryProcess(file);
		}
		if (!checkResults()){
			return;
		}
		filterResults();
		if (!checkResults()){
			return;
		}
		showInfo();
		phaser.arriveAndDeregister();
		System.out.printf("%s: Work completed.\n",Thread.currentThread().getName());
	}

	private void directoryProcess(File file) {
		File list[] = file.listFiles();
		if (list != null) {
			for (int i = 0; i < list.length; i++) {
				if (list[i].isDirectory()) {
					directoryProcess(list[i]);
				} else {
					fileProcess(list[i]);
				}
			}
		}
	}
	private void fileProcess(File file) {
		if (file.getName().endsWith(end)) {
			results.add(file.getAbsolutePath());
		}
	}
	private void filterResults() {
		List<String> newResults=new ArrayList<>();
		long actualDate=new Date().getTime();
		for (int i=0; i<results.size(); i++){
			File file=new File(results.get(i));
			long fileDate=file.lastModified();
			if (actualDate-fileDate< TimeUnit.MILLISECONDS.
					convert(1,TimeUnit.DAYS)){
				newResults.add(results.get(i));
			}
		}
		results=newResults;
	}

	private boolean checkResults() {
		if (results.isEmpty()) {
			System.out.printf("%s: Phase %d: 0 results.\n",Thread.currentThread().getName(),phaser.getPhase());
			System.out.printf("%s: Phase %d: End.\n",Thread.currentThread().getName(),phaser.getPhase());
			phaser.arriveAndDeregister();
			return false;
		} else {
			System.out.printf("%s: Phase %d: %d results.\n",Thread.
					currentThread().getName(),phaser.getPhase(),results.size());
			phaser.arriveAndAwaitAdvance();
			return true;
		}
	}
	private void showInfo() {
		for (int i=0; i<results.size(); i++){
			File file=new File(results.get(i));
			System.out.printf("%s: %s\n",Thread.currentThread().getName(),file.getAbsolutePath());
		}
		phaser.arriveAndAwaitAdvance();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result
				+ ((initPath == null) ? 0 : initPath.hashCode());
		result = prime * result + ((results == null) ? 0 : results.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FileSearch other = (FileSearch) obj;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		if (initPath == null) {
			if (other.initPath != null)
				return false;
		} else if (!initPath.equals(other.initPath))
			return false;
		if (results == null) {
			if (other.results != null)
				return false;
		} else if (!results.equals(other.results))
			return false;
		return true;
	}


	

}
