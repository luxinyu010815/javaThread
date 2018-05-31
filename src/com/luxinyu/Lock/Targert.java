package com.luxinyu.Lock;

public class Targert implements Runnable{
	BooleanLock lock = new BooleanLock(false);

	@Override
	public void run(){
		// TODO Auto-generated method stub
		try {
			lock.lock();
			System.out.println(Thread.currentThread().getName()+"»ñµÃËø");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unLock();
		}
		
	}

}
