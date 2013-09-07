package Stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class TestFileOutputStream01 {
	
	public static void main(String[] args) {
		long starttime=new Date().getTime();
		FileInputStream fis=null;
		FileOutputStream fos=null;
		
		try {
			fis=new FileInputStream("F:\\2");
			fos=new FileOutputStream("F:\\1");
			
			int len=0;
			while((len=fis.read())>=0){
				fos.write(len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (fis!=null) fis.close();
				if (fos!=null) fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			long endtime=new Date().getTime();
			long time=((endtime-starttime));
			System.out.println(time);
		}
	}
	
}
