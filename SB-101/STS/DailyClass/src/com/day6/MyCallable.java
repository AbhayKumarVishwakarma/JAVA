package com.day6;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyCallable implements Callable<Integer> {
     int num;
     
     public MyCallable(int num) {
		this.num = num;
	 }
     
     public Integer call() throws Exception {
    	 System.out.println(Thread.currentThread().getName() + " is finding sum of first " + num + " numbers");
    	    int sum = 0;
    	    for(int i = 0; i <= num; i++)
    	      sum+=i;
    	    return sum;
	}
     
     public static void main(String[] args) throws Exception {
    	 MyCallable[] jobs = {
    		      new MyCallable(10),
    		      new MyCallable(20),
    		      new MyCallable(30),
    		      new MyCallable(40),
    		      new MyCallable(50),
    		      new MyCallable(60)
    	};
    	 ExecutorService service = Executors.newFixedThreadPool(2);
    	 for(MyCallable job:jobs){
    	      Future<Integer> f=  service.submit(job);
    	      System.out.println(f.get());
    	 }
    	    
    	 service.shutdown(); 
	}
}
