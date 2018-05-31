package com.luxinyu.likeStop;

public class ThreadService {
	private Thread executeThread;
	public void execute(final Runnable task) {
		executeThread = new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Thread target = new Thread(task);
				target.setDaemon(true);
				target.start();
				try {
					target.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("程序执行结束");
			}
		};
		executeThread.start();
	}
	
	public void shutDown(long mills) {
		long currentMill = System.currentTimeMillis();
		while(true) {
			if(System.currentTimeMillis()-currentMill>mills) {
				executeThread.interrupt();
				System.out.println("服务超时");
				break;
			}
		}
	}
}
