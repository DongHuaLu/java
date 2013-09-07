import java.util.Arrays;
import java.util.List;


public class TestString01 {
	
	private static List<String> accType=Arrays.asList("jpg","gif","bmp","txt");
	
	public static void main(String[] args) {
		String[] filenames={"fgewitg.txt","fwetewt","gewge.bmp","getgeto.gegwg"};
		try{
			TestString01.showFileType(filenames);
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		
		

	}
	
	
	public static void showFileType(String[] filenames) throws FileTypeException{
		String fileType;
		for(String filename:filenames){
			System.out.println(filename);
			fileType=getFileType(filename);
			if (fileType==null){				
			}
			else if(accType.contains(fileType)){
				System.out.println(fileType);
			}
			else
			{
				throw new FileTypeException("文件名错误");				
			}
			System.out.println("-------------------");
		}
		
	}

	
	public static String getFileType(String filename){
		int pos=filename.lastIndexOf(".");
		if(pos==-1){
			System.out.println("文件名非法");
			return null;
		}
		return filename.substring(pos+1);
	}
}


	
