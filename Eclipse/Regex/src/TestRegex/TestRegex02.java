package TestRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex02 {
	
	public static void main(String[] args) {
		Pattern p=Pattern.compile("\\d{4}");
		Matcher m=p.matcher("1234-5678-0000-1111-3333");
		//�ж��Ƿ�ƥ��
		System.out.println(m.matches());
		//����ƥ��ָ��
		m.reset();
		//find()��ѯ��һ��ƥ��Ĵ�
		//group()����find��ƥ��Ĵ�
		//start(),end()����find������ʼ(����)λ��
		while(m.find()){
			System.out.println(m.group()+"["+m.start()+","+m.end()+"]");
		}
	}

	

}
