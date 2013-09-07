package com.Dolph.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import org.junit.Test;

public class FileService {
	
	public void uploadFile(InputStream is,String allPath){
		OutputStream os=null;
		try {
			os=new FileOutputStream(allPath);
			
			int len=0;
			byte [] buff=new byte[1024];
			while((len=is.read(buff))>0){
				os.write(buff, 0,len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public String getUUID(String filename){
		int i=filename.lastIndexOf(".");
		return UUID.randomUUID().toString()+filename.substring(i, filename.length());
	}

}
