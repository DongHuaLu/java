package TestRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex02 {
	
	public static void main(String[] args) {
		Pattern p=Pattern.compile("\\d{4}");
		Matcher m=p.matcher("1234-5678-0000-1111-3333");
		//判断是否匹配
		System.out.println(m.matches());
		//重置匹配指针
		m.reset();
		//find()查询下一个匹配的串
		//group()返回find所匹配的串
		//start(),end()返回find串的起始(结束)位置
		while(m.find()){
			System.out.println(m.group()+"["+m.start()+","+m.end()+"]");
		}
	}

	

}
