package com.luxinyu.chart2;

public class ThreadCard extends Thread{
	private static int index = 1;
	private static int MAX = 50;
	private String name;
	public ThreadCard(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(index<MAX) {
			System.out.println("¹ñÌ¨ºÅ£º"+name+"ÅÆºÅÎª£º"+index);
			//this.notifyAll();
			index++;
		}
	}
}
