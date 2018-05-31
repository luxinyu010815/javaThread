package com.luxinyu.deadLock;

public class OtherService {
	private final Object obj = new Object();
	private DeadLock deadLock;
	
	public DeadLock getDeadLock() {
		return deadLock;
	}

	public void setDeadLock(DeadLock deadLock) {
		this.deadLock = deadLock;
	}

	public void s1() {
		synchronized (obj){
			System.out.println("otherService.s1�ķ�����ִ��");
		}
	}
	
	public void s2() {
		synchronized (obj) {
			deadLock.m2();
		}
	}
}
