package com.luxinyu.deadLock;

public class DeadLockTest {
	public static void main(String[] args) {
		final OtherService otherService = new OtherService();
		final DeadLock deadLock = new DeadLock(otherService);
		otherService.setDeadLock(deadLock);
		new Thread() {
			@Override
			public void run() {
				while(true) {
					deadLock.m1();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				while(true) {
					otherService.s2();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
}
