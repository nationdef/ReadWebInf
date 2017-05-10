package com.lgf.test.rwi.bean;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;

public class NormalBean {
	
	public void getConfigFile(){
		
		
        try {
        	String path = NormalBean.class.getClassLoader().getResource("TestCn.xml").toURI().getPath();
            System.out.println("clStr:"+path);
            File file = new File(path);
            BufferedReader input = new BufferedReader(new FileReader(file));
            StringBuffer buffer = new StringBuffer();
            String text;

            while ((text = input.readLine()) != null)
                buffer.append(text + "\n");

            System.out.println("buffer.toString():"+buffer.toString());
        } catch (IOException ioException) {
        	ioException.printStackTrace();
            System.err.println("File Error!");
        } catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
