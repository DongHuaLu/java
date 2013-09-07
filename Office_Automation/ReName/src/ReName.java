import java.io.File;


public class ReName {
	public static void main(String[] args) {
		
		File dir=new File("E:\\教程\\项目\\西安OA\\OA");
		File[] files=dir.listFiles();
		for(int i=0;i<files.length;i++){
			String filename=files[i].getName();
			String newname=filename.replaceFirst("_【西安领航_何足道】_","_");
			files[i].renameTo(new File("E:\\教程\\项目\\西安OA\\OA\\"+newname));
		}
	}
	
}
