package com.xuefei.listener;

import org.apache.commons.fileupload.ProgressListener;

public class MyProgressListener implements ProgressListener{

	@Override
	public void update(long arg0, long arg1, int arg2) {
		System.out.println("已经上传了"+arg0+"字节，总字节数为"+arg1+"字节，现在正在上传第"+arg2+"个文件");
	}

}
