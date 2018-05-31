package com.luxinyu.deadLock;

public class DeadLock {
	private OtherService otherService;
	private final Object obj = new Object();
	public DeadLock(OtherService otherService) {
		this.otherService = otherService;
	}
	
	public void m1() {
		synchronized (obj) {
			otherService.s1();
		}
	}
	
	public void m2() {
		synchronized (obj) {
			System.out.println("DeadLock.m2方法在执行");
		}
	}
}
