package com.day6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorFrameworkDemo {
    public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(2);
		
		Runnable r = () -> {
			String threadName = Thread.currentThread().getName();
			System.out.println("Beginning : " + threadName);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
			}
				System.out.println("1");
				System.out.println("Completed : " + threadName);
				System.out.println();
		};
		
		for(int i=0; i<10; i++)
			es.submit(r);
		es.shutdown();
	}
}
