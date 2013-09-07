package IOtest;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class TestFile01 {
	
	public static void main(String[] args) {
		new TestFile01().listFile();
	}
	
	public void listFile(){
		File f=new File("F:\\gif");
		File[] files=f.listFiles(new Filetypefilter("txt"));
		for(File file:files){
			System.out.println(file.getName());
		}
	}
	
	
	private class Filetypefilter implements FilenameFilter{
		
		String filtertype;
		public Filetypefilter(String type) {
			filtertype=type;
		}
		@Override
		public boolean accept(File arg0, String arg1) {
			if (arg1.endsWith("."+filtertype)) return true;
			return false;
		}
		
	}

}
