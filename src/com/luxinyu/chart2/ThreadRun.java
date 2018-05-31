package com.luxinyu.chart2;

public class ThreadRun implements Runnable{
	private String name;
	private static int index = 1;
	private static int Max = 50;
	private Object obj = new Object();
	public ThreadRun() {}

	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		while(index<=Max) {
			
				try {
					System.out.println("当前柜台号："+Thread.currentThread().getName()+"当前卡号："+index);
					Thread.sleep(100);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				index++;
			}
		}
	}
	
