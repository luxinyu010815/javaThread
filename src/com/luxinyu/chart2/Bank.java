package com.luxinyu.chart2;

public class Bank {
	public static void main(String[] args) {
		new ThreadCard("1ºÅ¹ñ").start();
		new ThreadCard("2ºÅ¹ñ").start();
		new ThreadCard("3ºÅ¹ñ").start();
		new ThreadCard("4ºÅ¹ñ").start();
	}
}
