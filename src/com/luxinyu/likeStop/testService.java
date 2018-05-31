package com.luxinyu.likeStop;

public class testService {
	public static void main(String[] args) {
		ThreadService threadService = new ThreadService();
		threadService.execute(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(1000*10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		threadService.shutDown(1000*2);
	}
}
