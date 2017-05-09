package com.xuefei.web;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import com.xuefei.entity.FileBean;
import com.xuefei.listener.MyProgressListener;

public class UploadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DiskFileItemFactory factory=new DiskFileItemFactory(1024*10,new File("F:\\Temp"));
		ServletFileUpload upload=new ServletFileUpload(factory);
		
		//解决文件名中文乱码
		upload.setHeaderEncoding("utf-8");
		upload.setProgressListener(new MyProgressListener());
		List<FileItem> list=null;
		try {
			list = upload.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		List<FileBean> filelist=new ArrayList<FileBean>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		for (FileItem item : list) {
			String name = item.getName();
			name=name.substring(name.lastIndexOf("."));
			String uuid=UUID.randomUUID().toString();
			String filename=uuid+name;
			String type=item.getContentType();
			long size=item.getSize();
			
			String sizeStr = "";
			if(size>=1024 && size<1024*1024){
				sizeStr = (size/1024.0)+"KB";
			}else if(size>1024*1024 && size<=1024*1024*1024){
				sizeStr = (size/(1024*1024.0))+"MB";
			}else if(size >= 1024*1024*1024){
				sizeStr = (size/(1024*1024.0*1024))+"GB";
			}else{
				sizeStr = size+"B";
			}
			String date=sdf.format(new Date());
			
			FileBean bean=new FileBean();
			bean.setName(filename);
			bean.setType(type);
			bean.setSize(sizeStr);
			bean.setDate(date);
			
			filelist.add(bean);
			InputStream in = item.getInputStream();
			FileUtils.copyInputStreamToFile(in, new File("F:/imgs/"+filename));
			item.delete();//删除缓存中的内容
		}
		request.setAttribute("filelist",filelist );
		request.getRequestDispatcher("/success.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
