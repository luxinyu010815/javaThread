package com.luxinyu.multi;

public class MultiThread {
	private static int i = 0;
	private static boolean isProduct = false;
	private static Object lock = new Object();

	public synchronized void product() throws InterruptedException {
		while (isProduct) {
			this.wait();
		}

		i++;
		isProduct = true;
		this.notifyAll();
		System.out.println("p->" + i);
	}

	public synchronized void cusumoer() throws InterruptedException {
		while (!isProduct) {
			this.wait();
		}

		System.out.println("c->" + i);
		isProduct = false;
		this.notifyAll();
	}

	public static void main(String[] args) {
		final MultiThread pc = new MultiThread();
		new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true) {
					try {
						pc.product();
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
				// TODO Auto-generated method stub
				while (true) {
					try {
						pc.product();
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
				// TODO Auto-generated method stub
				while (true) {
					try {
						pc.cusumoer();
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
				// TODO Auto-generated method stub
				while (true) {
					try {
						pc.cusumoer();
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
