package com.luxinyu.test;

import org.junit.Test;

public class TestThread {
	public static void main(String[] args) {
		Runnable target = new Runnable() {
			//private volatile int count = 0;
			private int count = 0;
			@Override
			public synchronized void run() {
				// TODO Auto-generated method stub
				while(true) {
					count +=1;
					System.out.println(count);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		new Thread(target, "first").start();
		new Thread(target, "secound").start();
	}
	@Test
	public void testVolicate() {
		Runnable target = new Runnable() {
			private volatile int count = 0;
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					count +=1;
					System.out.println(count);
					try {
						Thread.sleep(1000*3);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		new Thread(target, "first").start();
		new Thread(target, "secound").start();
	}
}
