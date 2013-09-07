package TestThread;

public class TestBank {

	public static void main(String[] args) {
		new TestBank().begin();
	}
	
	
	public void begin(){
		Bank b=new Bank();
		new Thread(b,"�Ϲ�").start();
		new Thread(b,"����").start();
		while(true){
			if(b.times>=2){
				b.show();
				break;
			}

		}
	}
	
	
	
	class Bank implements Runnable{
		private int bankMoney;
		private int getMoney;
		private int homeMoney;
		private int times=0;
		
		public Bank() {
			bankMoney=5000;
			getMoney=2000;
			homeMoney=0;
		}
		
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName()+"ȡ��"+getMoney);
			homeMoney+=getMoney;
			int temp=bankMoney-getMoney;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			bankMoney=temp;
			times++;
		}
		
		public void show(){
			System.out.println("���:"+bankMoney+"����:"+homeMoney);
		}
	}
}
