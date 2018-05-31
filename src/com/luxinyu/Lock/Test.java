package com.luxinyu.Lock;

public class Test {
	public static void main(String[] args) throws InterruptedException {
		BooleanLock lock = new BooleanLock(false);
		Targert target = new Targert();
		new Thread(target, "T1").start();
		new Thread(target, "T2").start();
		new Thread(target, "T3").start();
		new Thread(target, "T4").start();
		Thread.sleep(100);
		lock.unLock();
	}
}
