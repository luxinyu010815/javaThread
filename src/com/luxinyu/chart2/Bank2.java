package com.luxinyu.chart2;

public class Bank2 {
	public static void main(String[] args) {
		Runnable r = new ThreadRun();
		new Thread(r, "һ�Ź�̨").start();
		new Thread(r, "���Ź�̨").start();
		new Thread(r, "���Ź�̨").start();
		new Thread(r, "�ĺŹ�̨").start();
	}
}
