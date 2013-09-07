package IOtest;

import java.io.File;
import java.io.FileFilter;

public class TestFile02 {
	public static void main(String[] args) {
		new TestFile02().listFileExceptDir();
		
	}
	
	
	public void listFileExceptDir(){
		File f=new File("F:\\gif");
		File[] fs=f.listFiles(new dirFilter());
		for(File file:fs){
			System.out.println(file.getName());
		}
		
	}
	
	private class dirFilter implements FileFilter{

		@Override
		public boolean accept(File file) {
			if(!file.isDirectory()) return true; 
				return false;
		}
		
	}

}
