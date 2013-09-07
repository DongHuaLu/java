package tools;
import java.io.UnsupportedEncodingException;


public class Enconding {
	public static String changeEnconding(String str){
		
		String newstr="";
		try {
			newstr=new String(str.getBytes("iso-8859-1"),"GB2312");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
		
		return newstr;
		
	}
}
