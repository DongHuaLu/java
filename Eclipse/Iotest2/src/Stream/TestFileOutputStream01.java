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
			fis=new FileInputStream("F:\\2.rar");
			fos=new FileOutputStream(new File("F:\\1.rar"));
			byte[] buf=new byte[1024];
			int len=0;
			while((len=fis.read(buf))>=0){
				fos.write(buf, 0, len);
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			long endtime=new Date().getTime();
			long time=((endtime-starttime));
			System.out.println(time);
		}
	}
	
}
