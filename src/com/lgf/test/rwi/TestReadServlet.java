package com.lgf.test.rwi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lgf.test.rwi.bean.NormalBean;

public class TestReadServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String path = this.getServletContext().getRealPath("WEB-INF/Test.xml");
         System.out.println("path:"+path);
         File file = new File(path);
         try {
             BufferedReader input = new BufferedReader(new FileReader(file));
             StringBuffer buffer = new StringBuffer();
             String text;

             while ((text = input.readLine()) != null)
                 buffer.append(text + "\n");

             System.out.println("buffer.toString():"+buffer.toString());
         } catch (IOException ioException) {
             System.err.println("File Error!");
         }
         
         NormalBean nb = new NormalBean();
         nb.getConfigFile();
		resp.setContentType("text/html");
		          PrintWriter out = resp.getWriter();
		          out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		          out.println("<HTML>");
		          out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		          out.println("  <BODY>");
		          out.print("    This is 4  ");
		          out.print(this.getClass());
		          out.println(", using the GET method");
		          out.println("  </BODY>");
		          out.println("</HTML>");
		          out.flush();
		          out.close();
		          
		         
		          
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}


}
