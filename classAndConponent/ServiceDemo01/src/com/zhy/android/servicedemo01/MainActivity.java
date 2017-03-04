package com.zhy.android.servicedemo01;

import java.io.Serializable;

import com.zhy.android.servicedemo01.MyService.MyBinder;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity implements Serializable{
	// new Activity()? ��ʾ�����ഴ��һ��������ѣ����ǲ���ʾһ��ҳ��
	// new MyService() 

	// 5.0���ϲ���ʹ����ʽ��������ʽ
	// startService ��������֮����ô�����ҳ���û���κεĹ��� stopService
	// bindService �����ҳ���֮��ҳ����������ھͻ�Ӱ��������������, ҳ���˳�  ����Ҳ�ͱ����١�
	
	// ҳ�������Ľ���(���ݴ���)��
	// 1.startService ͨ��intent����������ݷ�װ����
	// 2.bindService 
	
	// ������ô�������ݸ�ҳ�棿
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	private int count;
	public void startServiceClick(View view){
		count++;
		Intent intent = new Intent("testAction.test");
		intent.putExtra("Play", true);
		intent.putExtra("Index", 1);
		intent.putExtra("KillSelf", count >= 5);
		startService(intent);
//		stopService(intent); // �رշ���
	}
	
	/**
	 * �󶨷���ť������
	 * @param view
	 */
	public void bindServiceClick(View view){
		Intent intent = new Intent(this, MyService.class);
		intent.putExtra("Play", true);
		intent.putExtra("Index", 1);
		// 1.�󶨵ķ������
		// 2.�󶨵Ļص�����
		bindService(intent, connection, Context.BIND_AUTO_CREATE);
	}
	
	private ServiceConnection connection = new ServiceConnection() {
		@Override // ����δ����
		public void onServiceDisconnected(ComponentName name) {
			Log.d("zhou", "..onServiceDisconnected..:");
		}
		
		@Override // �������� 1.�󶨵ķ��������� 2.����Service.onBind�������صĶ���
		public void onServiceConnected(ComponentName name, IBinder service) {
			Log.d("zhou", "..onServiceConnected..service:"+service);
			MyBinder myBinder = (MyBinder) service;
			MyService myService = myBinder.getService();
		}
	};
	
	protected void onDestroy() {
		super.onDestroy();
//		// �����
//		unbindService(connection);
	};
}
