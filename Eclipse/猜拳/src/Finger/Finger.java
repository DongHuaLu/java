package Finger;

public class Finger {
	private int Finger;

	public int getFinger() {
		return Finger;
	}

	public void setFinger(int finger) {
		Finger = finger;
	}
	
	public int randomRage(int start,int end){		
		return (int) (Math.random()*((end-start)+start));
		
	}

}
