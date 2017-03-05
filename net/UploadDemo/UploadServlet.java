package com.javax.servlet.test;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Date;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class UploadServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws 
		ServletException, java.io.IOException{
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws 
		ServletException, java.io.IOException{
		// ȡ�����е�ͷ��Ϣ����
		/**
		java.util.Enumeration<String> names = req.getHeaderNames();
		while(names.hasMoreElements()){ // �ж��Ƿ��и����Ԫ��
			String headerName = names.nextElement(); // ȡ����һ��Ԫ��
			String headerValue = req.getHeader(headerName);
			System.out.println(headerName + "-->" +headerValue);
		}*/
		String fileName = req.getHeader("FileName");
		String fileLength = req.getHeader("FileLength");
		// 1.ȡ��ServletContext�����
		ServletContext cxt = getServletContext();
		// 2.ȡ��ָ���ļ������ļ��еľ���·��
		String absolutePath = cxt.getRealPath("upload"); // �������ļ������ļ��е�����
		System.out.println("absolutePath:" + absolutePath);
		// �Ե�ǰ��ʱ����Ϊ�ļ�������
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss", Locale.CHINA); // 1.ģ�� 2.����
		String name = format.format(new Date());
		ServletInputStream sis = req.getInputStream();// ��ȡ����������������������ϴ������ݶ���������������
		File file = new File(absolutePath, fileName == null ? name : fileName);
		FileOutputStream fos = new FileOutputStream(file);
		int length = 0; // ��ʾ����д����ֽ�����
		int i = -1; // ��������ÿ�ζ�ȡ�����ֽ���
		byte[] bytes = new byte[1024]; // ���������ȡ�����ֽ�
		while((i = sis.read(bytes, 0, bytes.length)) != -1){
			fos.write(bytes, 0, i);
			fos.flush();
			length += i;
		}
		// ��ʾ��д��
		fos.close();
		sis.close();

		resp.setCharacterEncoding("GBK");
		PrintWriter out = resp.getWriter();

		if (fileLength != null){
			try{
				int fileLen = Integer.parseInt(fileLength);
				if(fileLen == length){
					out.println("�ϴ��ɹ�");
				}else{
					out.println("�ϴ�ʧ��");
					file.delete();
				}
			}catch(NumberFormatException e){
				out.println("�ϴ�ʧ��");
				file.delete();
			}
			
		}
		
	}
}