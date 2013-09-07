package test;  
      
    import java.io.BufferedReader;  
    import java.io.File;  
    import java.io.FileReader;  
      
    public class CodeCounter {  
    	/**所有文件普通代码行数*/
    	private static long totalFilesLines=0;
        /**普通行数*/  
        private long normalLines=0;  
        /**注释行数*/  
        private long commentLines=0;  
        /**空白行数*/  
        private long spaceLines=0;  
        /**总行数*/  
        private long totalLines=0;  
        /*** 
         * 通过java文件路径构造该对象 
         * @param filePath java文件路径 
         */  
        public CodeCounter(String filePath){  
            tree(filePath);  
        }  
        /** 
         * 处理文件的方法 
         * @param filePath 文件路径 
         */  
        private void tree(String filePath){  
            File file=new File(filePath);  
            File[] childs=file.listFiles();  
            if(childs==null){  
                parse(file);  
            }else{  
            for(int i=0;i<childs.length;i++){  
                System.out.println("path:"+childs[i].getPath());  
                if(childs[i].isDirectory()){  
                    tree(childs[i].getPath());  
                }else{  
                    childs[i].getName().matches(".*\\.java$");   
                    System.out.println("当前"+childs[i].getName()+"代码行数:");  
                    parse(childs[i]);  
                    getCodeCounter();  
                }  
            }  
            }  
        }  
        /** 
         * 解析文件 
         * @param file 文件对象 
         */  
        private void parse(File file){  
            BufferedReader br=null;  
            boolean comment=false;  
            try {  
                br=new BufferedReader(new FileReader(file));  
                String line="";  
                while((line=br.readLine())!=null){  
                    line=line.trim();//去除空格  
                    if(line.matches("^[\\s&&[^\\n]]*$")) {     
                           spaceLines ++;     
                    }else if((line.startsWith("/*"))&& !line.endsWith("*/")) {     
                           commentLines ++;     
                           comment = true;     
                    }else if(true == comment) {     
                           commentLines ++;     
                    if(line.endsWith("*/")) {     
                           comment = false;     
                           }     
                    }else if(line.startsWith("//")) {     
                            commentLines ++;     
                    }else {     
                           normalLines ++;     
                          }   
                  }  
                  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        /** 
         * 得到Java文件的代码行数 
         */  
        private void getCodeCounter(){  
            totalLines=normalLines+spaceLines+commentLines;  
            System.out.println("普通代码行数:"+normalLines);  
            totalFilesLines+=normalLines;
            System.out.println("空白代码行数:"+spaceLines);  
            System.out.println("注释代码行数:"+commentLines);  
            System.out.println("代码总行数:"+totalLines);  
            normalLines=0;  
            spaceLines=0;  
            commentLines=0;  
            totalLines=0;  
        }  
        public static void main(String args[]){  
            CodeCounter counter=new CodeCounter("F:\\程序\\Office_Automation\\Office_Automation_003\\src");
            System.out.println("所有文件总行数"+totalFilesLines);
        }  
    }  