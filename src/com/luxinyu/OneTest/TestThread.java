package com.luxinyu.OneTest;

import org.junit.Test;

public class TestThread {
	/**
	 * 2018.5.20
	 * ����Thread.isAlive����
	 */
	@Test
	public void test1(){
		Thread t1 = new Thread(()-> {
			System.out.println("�߳�ִ��");
		});
		System.out.println("t1.isAlive:"+t1.isAlive());
		t1.start();
		System.out.println("t2.isAlive:"+t1.isAlive());
	}
	
	/**
	 * 2018.5.20
	 * ����Thread��interrupted����
	 * @throws InterruptedException 
	 */
	@Test
	public void test2() throws InterruptedException {
		Thread t2 = new Thread(()-> {
			while(!Thread.interrupted()) {
				System.out.println("�һ�û�б���");
			}
			System.out.println("���Ѿ�������ˣ����ǻ�������Ҫ˵");
		});
		t2.start();
		Thread.sleep(1000*3);
		t2.interrupt();
	}
}
