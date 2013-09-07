package Ğ¡Ã÷ºÍÄÖÖÓ;

public class Test {

	
	public static void main(String[] args) {
		Object key=new Object();
		NaoZhong nz=new NaoZhong(key);
		XiaoMing xm=new XiaoMing(key);
		Thread nzt=new Thread(nz);
		Thread xmt=new Thread(xm);
		nzt.start();
		xmt.start();
	}
	


}
