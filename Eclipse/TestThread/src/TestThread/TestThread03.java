package TestThread;

public class TestThread03 {
	public static void main(String[] args) {
		new TestThread03().begin();
	}
	
	
	public void begin(){
		MyThread mt11=new MyThread();
		MyThread mt22=new MyThread();
		Thread mt1=new Thread(mt11,"mt1");
		Thread mt2=new Thread(mt22,"mt2");
		mt1.start();
		mt2.start();
	}
	
	
	class MyThread implements Runnable{
		
		private int i;
		@Override
		public void run() {
			for(i=0;i<100;i++){
				System.out.println(Thread.currentThread().getName()+":"+i);
				Thread.yield();
			}
		}
		
		
		
	}

}
