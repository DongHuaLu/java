package Reader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TestReader01 {
	
	public static void main(String[] args) {
		BufferedReader br=null;
		PrintWriter pw=null;
		
		
		try {
			br=new BufferedReader(new FileReader("G:\\Documents and Settings\\Dolphh\\×ÀÃæ\\JSTL.txt"));
			pw=new PrintWriter(new BufferedWriter(new FileWriter("G:\\Documents and Settings\\Dolphh\\×ÀÃæ\\JSTL2.txt")));
			String buf=null;
			while ((buf=br.readLine())!=null){
				System.out.println(buf);
				pw.println(buf);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
			if(br!=null)	br.close();
			if(pw!=null)	pw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
	}

}
