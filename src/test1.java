
public class test1 {
	public static void main(String[] args){
		new Thread("customer-read"){
			@Override
			public void run(){
				readDb();
			}
		}.start();
		
		new Thread("customer-write"){
			@Override
			public void run(){
				writeDb();
			}
		}.start();
	}
	
	public static void readDb(){
		println("正在从数据库中读取文件");
		try {
			Thread.sleep(1000*80L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		println("已读取完毕");
	}
	
	public static void writeDb(){
		println("正在写数据");
		try {
			Thread.sleep(1000*80L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		println("写完成");
	}
	
	public static void println(String message){
		System.out.println(message);
	}
}
