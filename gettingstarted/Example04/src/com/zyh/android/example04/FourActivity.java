package com.zyh.android.example04;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class FourActivity extends Activity {
	
	// ��������µ�ҳ�棿
	// android �Ĵ������1 Activity 2. BroadcastReceiver 3.Service 4.ContentProvider
	// �Ĵ����֮�����ϵͨ������Intent
	// Intent ��ͼ 
	// 1.CompoundName ����� ����Ҫ���� CompoundName ���������˼���Ǹ�֪ϵͳ����Ҫȥ�����ĸ���
	//		intent.setClass(packageContext, cls)
	//		intent.setClassName(packageContext, className)
	//		intent.setComponent(component);
	// 2.Action�� Data/Type CompoundName
	
	// ÿ�������������һ���µ�ҳ��ʱ��Ҫ��AndroidManifest.xml�������ҳ���ע��

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
//		Intent intent = new Intent();
		// 1.context 2.��ת��ҳ���class����
//		intent.setClass(packageContext, cls)
//		intent.setClassName(packageContext, className)
//		intent.setComponent(component);
//		intent.setAction(action);
	}
}
