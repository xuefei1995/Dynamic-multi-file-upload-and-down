package com.xuefei.listener;

import org.apache.commons.fileupload.ProgressListener;

public class MyProgressListener implements ProgressListener{

	@Override
	public void update(long arg0, long arg1, int arg2) {
		System.out.println("�Ѿ��ϴ���"+arg0+"�ֽڣ����ֽ���Ϊ"+arg1+"�ֽڣ����������ϴ���"+arg2+"���ļ�");
	}

}
