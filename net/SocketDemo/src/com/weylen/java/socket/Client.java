package com.weylen.java.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	// Socket
	// 1.�ȷ���Ϣ
	
	private boolean isExit;
	public static void main(String args[]){
		new Client().clientServer();
	}
	
	private void clientServer(){
		try {
			// 1.��������ip��ַ 2.�˿ں�
			// ����������û���׳��κε��쳣 ��˵�����ӷ������ɹ�
			Socket client = new Socket("192.168.1.100", 12321);
			new ReadConsole(client).start();
			new ReadFromServer(client).start();
		} catch (UnknownHostException e) { // δ֪�����쳣
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private class ReadConsole extends Thread{
		
		private Socket client;
		private ReadConsole(Socket client){
			this.client = client;
		}
		
		@Override
		public void run(){
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				PrintWriter printWriter = new PrintWriter(client.getOutputStream());
				String line = null;
				while(!isExit && (line = reader.readLine()) != null){
					System.out.println("����̨��������ݣ�"+line);
					printWriter.println(line);
					printWriter.flush();
					if (line.equals("exit")){
						isExit = true;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private class ReadFromServer extends Thread{
		
		private Socket client;
		
		private ReadFromServer(Socket client){
			this.client = client;
		}
		
		@Override
		public void run(){
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
				String line = null;
				while(!isExit && (line = reader.readLine()) != null){
					System.out.println(line);
					if (line.equals("exitOk")){
						isExit = true;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
