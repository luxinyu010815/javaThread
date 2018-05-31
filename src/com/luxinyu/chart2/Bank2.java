package com.luxinyu.chart2;

public class Bank2 {
	public static void main(String[] args) {
		Runnable r = new ThreadRun();
		new Thread(r, "一号柜台").start();
		new Thread(r, "二号柜台").start();
		new Thread(r, "三号柜台").start();
		new Thread(r, "四号柜台").start();
	}
}
