package TestRegex;

public class TestReplace {
	public static void main(String[] args) {
	String str="1231kooperkt122ok23532";
	System.out.println(str.replaceAll("\\d", "*"));
	System.out.println(str.replaceAll("\\d+", "*"));
	
	}
}
