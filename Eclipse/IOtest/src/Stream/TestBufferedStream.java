package Stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class TestBufferedStream {
	
	public static void main(String[] args) {
		long starttime=new Date().getTime();
		BufferedInputStream bis=null;
		BufferedOutputStream bos=null;
		
		try {
			bis=new BufferedInputStream(new FileInputStream("F:\\2"));
			bos=new BufferedOutputStream(new FileOutputStream("F:\\1"));
			int len=0;
			while((len=bis.read())>=0){
				bos.write(len);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (bis!=null) bis.close();
				if (bos!=null) bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			long endtime=new Date().getTime();
			long time=((endtime-starttime));
			System.out.println(time);
		}
	}

}
