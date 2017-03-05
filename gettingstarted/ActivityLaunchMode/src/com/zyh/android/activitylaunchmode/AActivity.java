package com.zyh.android.activitylaunchmode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class AActivity extends Activity {

	// Activity����ģʽ����AndroidManifest.xml�������Activity�����á�
	// standard��׼�� A-->B-->C-->A ��׼ģʽ�� ���е���ת�������һ���µ�ʵ��
	// singleTop ��ҳ��Ķ�ջ��ջ��ֻ��һ��ʵ�� A-->B-->A-->A
	// ���ջ��������ҳ����ͬһ���Ļ� ��ֻ�����һ���µ�ʵ��
	
	// singleTask ��ͬһ����ջ����ֻ�����һ���µ�ʵ�� B-->A
	// singleInstance ������Ķ�ջ���涼ֻ�����һ���µĶ���
	
	private boolean boo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d("zhou", "..onCreate..this:"+this);
		boo = getIntent().getBooleanExtra("boo", false);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		Log.d("zhou", "..onResume..ִ����onResume����");
	}
	
	/**
	 * ��ת��ť�ļ����¼�
	 * @param view
	 */
	public void jumpClick(View view){
		Intent intent = new Intent(this, BActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
		startActivity(intent);
	}
}
