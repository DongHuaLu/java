package TestRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex03 {
	public static void main(String[] args) {
		String str="320548198401143584,320684198910256744,3284841954458515631";
		Pattern p=Pattern.compile("(\\d{6})(\\d{8})\\d{4}");	
		Matcher m=p.matcher(str);
		while(m.find()){
			System.out.println("��Դ��:"+m.group(1)+",��������:"+m.group(2));
		}
		
		String str2="<td>ͽ��</td><td>̫��ͷ��</td><td>Ͷ��</td>";
		//̰��ģʽ,.*��ƥ�����е��ַ�
		//�ҵ����:ͽ��</td><td>̫��ͷ��</td><td>Ͷ��
		Pattern p2=Pattern.compile("<td>(.*)</td>");
		Matcher m2=p2.matcher(str2);
		while(m2.find()){
			System.out.println(m2.group(1));
		}
		//��̰��ģʽ,����ƥ���һ����β
		Pattern p3=Pattern.compile("<td>(.*?)</td>");
		Matcher m3=p3.matcher(str2);
		while(m3.find()){
			System.out.println(m3.group(1));
		}
		
	}
}
