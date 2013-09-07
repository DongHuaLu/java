package TestRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex03 {
	public static void main(String[] args) {
		String str="320548198401143584,320684198910256744,3284841954458515631";
		Pattern p=Pattern.compile("(\\d{6})(\\d{8})\\d{4}");	
		Matcher m=p.matcher(str);
		while(m.find()){
			System.out.println("生源地:"+m.group(1)+",出生日期:"+m.group(2));
		}
		
		String str2="<td>徒弟</td><td>太低头的</td><td>投点</td>";
		//贪婪模式,.*会匹配所有的字符
		//找到结果:徒弟</td><td>太低头的</td><td>投点
		Pattern p2=Pattern.compile("<td>(.*)</td>");
		Matcher m2=p2.matcher(str2);
		while(m2.find()){
			System.out.println(m2.group(1));
		}
		//非贪婪模式,仅仅匹配第一个结尾
		Pattern p3=Pattern.compile("<td>(.*?)</td>");
		Matcher m3=p3.matcher(str2);
		while(m3.find()){
			System.out.println(m3.group(1));
		}
		
	}
}
