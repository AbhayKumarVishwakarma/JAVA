package com.day6;

public class WaitNotifyDemo extends Thread {
     public void run() {
		synchronized (this) {
			try {
				System.out.println(1);
				this.notify();
				this.wait();
				System.out.println(3);
				this.notify();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	 }
     public static void main(String[] args) {
		WaitNotifyDemo w = new WaitNotifyDemo();
		w.start();
		synchronized (w) {
			try {
				w.wait();
				System.out.println(2);
				w.notify();
				w.wait();
				System.out.println(4);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}
}
