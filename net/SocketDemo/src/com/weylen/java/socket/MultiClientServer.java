package com.weylen.java.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiClientServer {
	
	private int index; // �����Ϸ����������
	public static final int MAX_SIZE = 1; // ������������������
	private List<Socket> clients = new ArrayList<>();
	private ServerSocket serverSocket;
	private boolean isWhile = true; // �ж��Ƿ�ѭ���Ƿ�һֱ����
	// ����һ��������̳߳�
	private ExecutorService executorService = Executors.newCachedThreadPool();
	
	public static void main(String args[]){
		new MultiClientServer().startServer();
	} 
	
	/**
	 * ����������
	 */
	private void startServer(){
		try {
			serverSocket = new ServerSocket(54321);
			openClient();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ������
	 * @throws IOException 
	 */
	private void openClient() throws IOException{
		isWhile = true;
		while(clients.size() < MAX_SIZE){
			Socket client = serverSocket.accept();
			index++;
			clients.add(client);
			// ��ÿһ�������Ϸ������Ŀͷ��˷���һ���߳�
			executorService.execute(new ReadFromClient(client, index));
		}
		isWhile = false;
	}
	
	/**
	 * ѭ����ȡ�ͷ��˷��͵���Ϣ
	 */
	private class ReadFromClient extends Thread{
		
		private Socket client;
		private int code;
		private boolean isExit;
		private ReadFromClient(Socket client, int code){
			this.client = client;
			this.code = code;
		}
		
		@Override
		public void run(){
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));	
				String line = null;
				while(!isExit && (line = reader.readLine()) != null){
					System.out.println("���յ���"+code+"���˷��͵���Ϣ��"+line);
					if ("exit".equals(line)){
						clients.remove(client);
						PrintWriter printWriter = new PrintWriter(client.getOutputStream());
						printWriter.println("exitOk");
						printWriter.flush();
						client.close();
						if (!isWhile){
							openClient();
						}		
						isExit = true;
					}else{
						sendToAll("��"+code+"���ˣ�" + line);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * ������Ϣ��������
		 * @param line
		 * @throws IOException
		 */
		private void sendToAll(String line) throws IOException{
			for(Socket client : clients){
				PrintWriter printWriter = new PrintWriter(client.getOutputStream());
				printWriter.println(line);
				printWriter.flush();
			}
		}
	}
}
