package com.luxinyu.OneTest;

import org.junit.Test;

public class TestThread {
	/**
	 * 2018.5.20
	 * 测试Thread.isAlive方法
	 */
	@Test
	public void test1(){
		Thread t1 = new Thread(()-> {
			System.out.println("线程执行");
		});
		System.out.println("t1.isAlive:"+t1.isAlive());
		t1.start();
		System.out.println("t2.isAlive:"+t1.isAlive());
	}
	
	/**
	 * 2018.5.20
	 * 测试Thread的interrupted方法
	 * @throws InterruptedException 
	 */
	@Test
	public void test2() throws InterruptedException {
		Thread t2 = new Thread(()-> {
			while(!Thread.interrupted()) {
				System.out.println("我还没有别打断");
			}
			System.out.println("我已经被打断了，但是还有遗言要说");
		});
		t2.start();
		Thread.sleep(1000*3);
		t2.interrupt();
	}
}
