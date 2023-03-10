package com.day6;

class GoDown {
	boolean isGodownFull;	//if true means no more space if false means space is available
	
	synchronized void getItemFromGodown() {
		if(!isGodownFull) {
			//you are here means GoDown is empty so we cannot get any item
			try {
				System.out.println("Calling wait in getItemFromGodown");
				wait();
				System.out.println("Waiting is over in getItemFromGodown");
			}catch(InterruptedException ex) {
				System.out.println(ex);
			}
		}
		System.out.println("Getting item from godown");
		//update the godown status
		isGodownFull = false;
		//now the godown is empty, call the notify() method so that if somebody is waiting for the godown to vacant they may execute
		notify();
	}
	
	synchronized void putItemInGodown() {
		if(isGodownFull) {
			//you are here means GoDown is full so we cannot put any item
			try {
				System.out.println("Calling wait in putItemInGodown");
				wait();
				System.out.println("Waiting is over in putItemInGodown");
			}catch(InterruptedException ex) {
				System.out.println();
			}
		}
		//you are here means godown is vacant so you can put item
		System.out.println("Putting item in godown");
		//update the godown status
		isGodownFull = true;
		//now the godown is full, call the notify() method so that if somebody is waiting for the godown to full they may execute
		notify();
	}
}


class Consumer implements Runnable{
	GoDown goDown;
	
	Consumer(GoDown goDown){
		this.goDown = goDown;
	}
	
	public void run() {
		goDown.getItemFromGodown();
	}
}


class Producer implements Runnable{
	GoDown goDown;
	
	Producer(GoDown goDown){
		this.goDown = goDown;
	}
	
	public void run() {
		goDown.putItemInGodown();
	}
}


public class WaitNotifyExample {
	public static void main(String[] args) {
		//Creating an object of class GoDown
		GoDown goDown = new GoDown();
		//create Thread object for Consumer
		Thread consumerThread = new Thread(new Consumer(goDown));
		//create Thread object for Producer
		Thread producerThread = new Thread(new Producer(goDown));
		//starting consumerThread
		consumerThread.start();
		//starting producerThread
		producerThread.start();
		try {
			consumerThread.join();
			producerThread.join();
		}catch(InterruptedException ex) {
			System.out.println(ex);
		}
		System.out.println("Bye-bye main");
	}
}