package com.xuefei.web;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String filename="��Ů.jpg";		
		InputStream in = this.getServletContext().getResourceAsStream("/upload/"+filename);
		filename=URLEncoder.encode(filename,"utf-8");//��Ҫ���룬��������Զ�����
		
//		String bname = request.getHeader("user-agent");
//		String name="";
//		//�ж��Ƿ�ΪIE�����
//		if(bname.contains("Trident")){
//			name="attachment;filename="+filename;
//		}else {
//			name="attachment;filename*="+filename;
//		}
		
		response.setHeader("content-disposition", "attachment;filename="+filename);
		ServletOutputStream ops = response.getOutputStream();
		byte[] b=new byte[1024];
		int len=0;
		while((len=in.read(b))!=-1){
			ops.write(b, 0, len);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
