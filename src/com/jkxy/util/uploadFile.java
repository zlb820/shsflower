package com.jkxy.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class uploadFile {
	InputStream is;
	public void upload(File file,String path){
		
		try {
			is=new FileInputStream(file);
			OutputStream os=new  FileOutputStream(path);
			byte buffer[]=new byte[1024];
			int count=0;
			while ((count=is.read(buffer))>0){
				os.write(buffer, 0, count);
			}
			//先关os 后关is
			os.close();
			is.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
	}
}
