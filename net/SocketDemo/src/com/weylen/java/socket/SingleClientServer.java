package com.weylen.java.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleClientServer {
	// http���򽻻�ģʽ �ͷ���-->��������-->���������ս�������Ȼ����Ӧ(�޷���ɼ�ʱͨѶ)
	// ����ʹ��http����һ��������ģʽ ÿ��һ��ʱ������һ�η����� �ĵ��� ���ڴ� ����
	// TCP/TP ��������(Socket) ����������(UDP)
	// Socket���ͷ��ˣ� �����ͷ���ͬʱ����
	// ServerSocket������ˣ�
	public static void main(String args[]){
		new SingleClientServer().startServer();
	}
	
	/**
	 * ����������
	 */
	public void startServer(){
		try {
			// 1~1024ϵͳ�˿ں�(80)	
			ServerSocket serverSocket = new ServerSocket(12321);
			// �������� ����һ���ͷ��������ϴ˷�����֮�󼴴򿪷��� ���ҷ��������ϴ˷������Ŀͷ��˶���
			Socket client = serverSocket.accept();
			InetAddress inetAddress = client.getInetAddress();
			System.out.println("address:"+inetAddress.getHostAddress());
			new ReadFromClient(client).start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ѭ����ȡ�ͷ��˷��͵���Ϣ
	 */
	private class ReadFromClient extends Thread{
		
		private Socket client;
		private ReadFromClient(Socket client){
			this.client = client;
		}
		
		@Override
		public void run(){
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
				PrintWriter printWriter = new PrintWriter(client.getOutputStream());
				String line = null;
				System.out.println("��ʼ��ȡ�ͷ��˵�����");
				while((line = reader.readLine()) != null){
					System.out.println("���������յ�����:"+line);
					printWriter.println("ni sb me");
					printWriter.flush();
				}
				System.out.println("��ȡ�ͷ������ݽ���");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
