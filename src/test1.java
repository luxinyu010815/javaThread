
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
		println("���ڴ����ݿ��ж�ȡ�ļ�");
		try {
			Thread.sleep(1000*80L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		println("�Ѷ�ȡ���");
	}
	
	public static void writeDb(){
		println("����д����");
		try {
			Thread.sleep(1000*80L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		println("д���");
	}
	
	public static void println(String message){
		System.out.println(message);
	}
}
