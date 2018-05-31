package com.luxinyu.multi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CaptureService {
	private static final Object lock = new Object();
	private static final int maxSize = 5;
	private static final LinkedList<Controll> controlls = new LinkedList<>();

	public static void main(String[] args) throws Exception{
		List<String> workerList = Arrays.asList("M1", "M2", "M3", "M4", "M5", "M6", "M7", "M8", "M9", "M10");

		for (String name : workerList) {

			new Thread(name) {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					synchronized (controlls) {
						while (controlls.size() > maxSize) {
							try {
								controlls.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							controlls.add(new Controll());
						}
						System.out.println(this.currentThread().getName() + " is begin!");
					}
					
					
					synchronized (controlls) {
						try {
							System.out.println(this.currentThread().getName() + " is working!");
							Thread.sleep(1000);
							System.out.println(this.currentThread().getName() + " is end!");
							controlls.removeFirst();
							controlls.notifyAll();
						} catch (Exception e) {
							// TODO Auto-generated catch block
						}
						
					}
				}
			}.start();
		}
	}

	private static class Controll {

	}
}
