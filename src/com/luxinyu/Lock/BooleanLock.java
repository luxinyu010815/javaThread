package com.luxinyu.Lock;

import java.util.ArrayList;
import java.util.Collection;

public class BooleanLock implements Lock{
	
	private boolean inivalLock;
	private Collection<Thread> list = new ArrayList<>();
	public BooleanLock(boolean inivalLock) {
		this.inivalLock = inivalLock;
	}

	@Override
	public synchronized void lock() throws InterruptedException {
		// TODO Auto-generated method stub
		while(inivalLock) {
			list.add(Thread.currentThread());
			this.wait();
			list.remove(Thread.currentThread());
		}
		inivalLock = true;
	}

	@Override
	public synchronized void lock(long mills) throws InterruptedException {
		// TODO Auto-generated method stub
		while(inivalLock) {
			long start = System.currentTimeMillis();
			Thread.sleep(1000*3);
		}
	}

	@Override
	public synchronized void unLock() {
		// TODO Auto-generated method stub
		inivalLock=false;
		System.out.println(Thread.currentThread().getName()+" Õ∑≈À¯");
		this.notify();
	}

	@Override
	public Collection<Thread> getLockCollections() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCollectionSize() {
		// TODO Auto-generated method stub
		return 0;
	}

}
