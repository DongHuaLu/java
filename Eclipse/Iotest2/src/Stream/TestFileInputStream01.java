package Stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestFileInputStream01 {
	public static void main(String[] args) {
		FileInputStream fis=null;
		
		try {
			fis=new FileInputStream("G:\\Documents and Settings\\Dolphh\\×ÀÃæ\\JSTL.txt");
			byte[] buf=new byte[1024];
			int len=0;
			while ((len=fis.read(buf))>=0){
				System.out.write(buf, 0, len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (fis!=null)
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

}
