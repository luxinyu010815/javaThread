package com.luxinyu.ThreadLocal;

import java.util.Random;

public class ThreadLocalTest {
	private static ThreadLocal<String> local = new ThreadLocal<>();
	public static void main(String[] args) {
		Runnable run = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				local.set(Thread.currentThread().getName());
				if(Thread.currentThread().getName().equals("Thread-1")) {
					local.set("hehhe");
				}
				try {
					Thread.sleep(new Random().nextInt(1000));
					System.out.println(Thread.currentThread().getName()+" "+local.get());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		new Thread(run).start();
		new Thread(run).start();
	}
}
