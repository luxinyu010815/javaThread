package com.luxinyu.Lock;

import java.util.Collection;

public interface Lock {
	//boolean inivalLock = false;
	//Collection<Thread> lockCollections = new ArrayList<Thread>();
	
	public void lock() throws InterruptedException;
	
	public void lock(long mills) throws InterruptedException;
	
	public void unLock();
	
	public Collection<Thread> getLockCollections();
	
	public int getCollectionSize();
}
