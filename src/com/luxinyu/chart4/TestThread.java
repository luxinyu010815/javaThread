package com.luxinyu.chart4;

public class TestThread {
	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread().getName()+"start");
		new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(Thread.currentThread().getName()+"running");
				try {
					Thread deamon = new Thread() {
						public void run() {
							try {
								sleep(1000*100);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						};
					};
					deamon.setDaemon(true);
					deamon.start();
					Thread.sleep(1000*20);
					System.out.println(Thread.currentThread().getName()+"down");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();
		
		System.out.println(Thread.currentThread().getName()+"down");
	}
}
