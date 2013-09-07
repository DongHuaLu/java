package 小明和闹钟;

public class NaoZhong implements Runnable{
	Object key;
	
	public NaoZhong(Object key) {
		this.key=key;
	}
	
	public  void ring(){
		synchronized(key){
			System.out.println("起床了");
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
			ring();
		}
		
	}

}
