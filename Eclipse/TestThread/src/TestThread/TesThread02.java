package TestThread;

public class TesThread02 {
	
	public static void main(String[] args) {
		new TesThread02().be();
	}
	
	public void be(){
		Thread tt=new Thread(new TestThreadx(),"abc");
		tt.start();
		for (int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+i);
		}
	}
	
	
	
	
	class TestThreadx implements Runnable{

		
		
		@Override
		public void run() {
			for(int i=0;i<100;i++){
				System.out.println(Thread.currentThread().getName()+i);
			}
		}
		
	}
	

}
