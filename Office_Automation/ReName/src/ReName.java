import java.io.File;


public class ReName {
	public static void main(String[] args) {
		
		File dir=new File("E:\\�̳�\\��Ŀ\\����OA\\OA");
		File[] files=dir.listFiles();
		for(int i=0;i<files.length;i++){
			String filename=files[i].getName();
			String newname=filename.replaceFirst("_�������캽_�������_","_");
			files[i].renameTo(new File("E:\\�̳�\\��Ŀ\\����OA\\OA\\"+newname));
		}
	}
	
}
