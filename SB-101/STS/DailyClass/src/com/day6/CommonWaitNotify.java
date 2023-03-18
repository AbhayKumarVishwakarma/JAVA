package com.day6;

class Common{
	boolean flag = true;
	int num;
	
	synchronized void produserr(int i) throws InterruptedException {
		if(flag == true) {
			num = i;
			flag = false;
			notify();
			wait();
		}
	}
	
	synchronized int consumerr() throws InterruptedException {
		if(flag == true) wait();
		flag = true;
		notify();
		return num;
	}
}

class Produserr extends Thread{
	Common c;
	public Produserr(Common c) {
		this.c = c;
	}
	@Override
	public void run() {
		int i = 1;
		while(true) {
			try {
				System.out.println("Produser is produsing : " + i);
				c.produserr(i);
				i++;
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Consumerr extends Thread{
	Common c;
	public Consumerr(Common c) {
		this.c = c;
	}
	@Override
	public void run() {
		while(true) {
			try {
				int i = c.consumerr();
				System.out.println("Consumer consumed : " + i);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class CommonWaitNotify {
    public static void main(String[] args) {
		Common c = new Common();
		Produserr p = new Produserr(c);
		Consumerr co = new Consumerr(c);
		p.start();
		co.start();
	}
}
