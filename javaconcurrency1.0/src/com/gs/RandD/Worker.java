package com.gs.RandD;

public class Worker {
	private String name;
	private int age;
	
	public Worker(String name , int age) {
		this.name = name;
		this.age = age;
		System.out.println("i am a worker " + this.name + this.age);
	}
	
	public void doWork(){
		System.out.println("Worker is doing its work");
	}
}
