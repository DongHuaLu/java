package 小明和闹钟;

public class XiaoMing implements Runnable{
	Object key;
	
	public XiaoMing(Object key) {
		this.key=key;
	}
	
	public synchronized void getUp(){
		synchronized (key) {
			System.out.println("知道了");
			key.notify();
			try {
				Thread.sleep(2000);
				key.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	@Override
	public void run() {
		while(true){
			getUp();
		}
			
		
		
	}

}
