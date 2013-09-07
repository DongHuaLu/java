package TestRegex;

public class TestRegex01 {
	
	public static void main(String[] args) {
		System.out.println("4567895".matches("[0-9]*"));
		//检测小数
		System.out.println("23.5".matches("\\d+\\.?\\d+"));
		
		System.out.println("0512-65125488-01".matches("[0-9]{3,4}-[0-9]{8}-?[0-9]{0,2}"));
		//0-35
		System.out.println("11".matches("\\d{1}||[12]{1}\\d||[3]{1}[0-5]{1}"));
		//匹配一个身份证号
		System.out.println("32068415848784154X".matches("\\d{15}||\\d{18}||\\d{17}[X]"));
		//匹配一个邮箱地址
		System.out.println("cege@1-63.com.cn".matches("\\w+@[\\w-]+\\.\\w{2,6}\\.?\\w{0,6}"));
		
	}

}
