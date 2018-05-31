package com.luxinyu.ThreadPool;

import java.util.ArrayList;
import java.util.LinkedList;

public class SimpleThreadPool {
	private static int size = 0;
	private final static int DEFAULT_SIZE = 10;
	private final static String name = "Thread-";
	private final static ThreadGroup group = new ThreadGroup("SimpleThreadPool");
	private volatile static LinkedList<Runnable> RUN_QUEUE = new LinkedList<>();
	private volatile static ArrayList<WorkTask> TASK_LIST = new ArrayList<>();
	
	public static void main(String[] args) {
		SimpleThreadPool pool = new SimpleThreadPool();
		for(int i=0;i<100;i++) {
			pool.submit(()->{
				System.out.println(Thread.currentThread()+"is working");
				try {
					Thread.sleep(1000*5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread()+"finish");
			});
		}
	}
	public SimpleThreadPool() {
		this(DEFAULT_SIZE);
	}

	public SimpleThreadPool(int size) {
		this.size = size;
		init();
	}
	
	public void init() {
		for(int i=0;i<size;i++) {
			this.createWorkTask(group,name+i).start();;
		}
	}
	
	private WorkTask createWorkTask(ThreadGroup group,String name) {
		// TODO Auto-generated method stub
		WorkTask workTask = new WorkTask(group, name);
		TASK_LIST.add(workTask);
		return workTask;
	}
	
	public void submit(Runnable run) {
		synchronized (RUN_QUEUE) {
			RUN_QUEUE.addLast(run);
			RUN_QUEUE.notifyAll();
		}
	}

	private enum TaskStatue {
		Free, Dead, Block, Running
	};

	private static class WorkTask extends Thread {
		private volatile static TaskStatue status = TaskStatue.Free;
		private Runnable runnable;
		public WorkTask(ThreadGroup group, String name) {
			// TODO Auto-generated constructor stub
			super(group, name);
		}
		public TaskStatue getTaskStatus() {
			return status;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			OUTER: while (status != TaskStatue.Dead) {
				synchronized (RUN_QUEUE) {
					while (RUN_QUEUE.size() == 0) {
						try {
							RUN_QUEUE.wait();
							status = TaskStatue.Block;
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							break OUTER;
						}
					}
					runnable = RUN_QUEUE.removeFirst();
				}
				if(runnable!=null) {
					runnable.run();
					status = TaskStatue.Running;
				}
			}
		}
		public void close() {
			status = TaskStatue.Dead;
		}
	}
}
