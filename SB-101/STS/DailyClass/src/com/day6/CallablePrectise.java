package com.day6;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Demo implements Callable{
	
	int i;
	
	public Demo(int i) {
		this.i = i;
	}

	@Override
	public Object call() throws Exception {
		System.out.print(Thread.currentThread().getName() + "---------> ");
		int sum = 0;
		while(i>0) {
			sum += i;
			i--;
		}
		return sum;
	}
	
}

public class CallablePrectise {
     public static void main(String[] args) throws InterruptedException, ExecutionException {
		Demo[] list = {
				new Demo(5),
				new Demo(10),
				new Demo(15),
				new Demo(20),
				new Demo(25),
				new Demo(30)
		};
		ExecutorService es = Executors.newFixedThreadPool(2);  // ThreadPool
		for(Demo d : list) {
			Future f = es.submit(d);                           // returning as future
			System.out.println(f.get());                       // getting the value from future
		}
		es.shutdown();
	}
}
