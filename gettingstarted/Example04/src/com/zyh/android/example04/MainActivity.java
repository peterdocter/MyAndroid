package com.zyh.android.example04;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
	
	// ��������µ�ҳ�棿
	// android �Ĵ������1 Activity 2. BroadcastReceiver 3.Service 4.ContentProvider
	// ÿ�������������һ���µ�ҳ��ʱ��Ҫ��AndroidManifest.xml�������ҳ���ע��
	// �Ĵ����֮�����ϵͨ������Intent
	// Intent ��ͼ  ��ʾ��ת ������ȷ��֪��Ҫ��ת��ҳ��
	// 1.ComponentName ����� ����Ҫ���� ComponentName ���������˼���Ǹ�֪ϵͳ����Ҫȥ�����ĸ���
	//		intent.setClass(packageContext, cls)
	//		intent.setClassName(packageContext, className)
	//		intent.setComponent(component);
	// 2.Action�� Data/Type ��ʽ��ת ��ϵͳѡ����ת��ҳ��
	//   Action �ͱ�ʾ����ϵͳ����Ҫ����һ������
	//   Intent.ACTION_VIEW �ͱ�ʾ����ϵͳ��������һ����ָ�����ݵ���
	//   ָ�������ݾ�ͨ��data��type������
	//   Intent.ACTION_CALL ��绰 ��Ҫ����绰Ȩ��
	//   Intent.ACTION_DIAL ��ת������绰����

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				// �趨��ת������ setClass�޷Ǿ����趨һ��ComponentName����
//				intent.setClass(MainActivity.this,  ThreeActivity.class);
//				intent.setClassName(MainActivity.this, "com.zyh.android.example04.ThreeActivity");
//				intent.setClassName(getPackageName(), "com.zyh.android.example04.ThreeActivity");
				ComponentName cName = new ComponentName(getPackageName(), "com.zyh.android.example04.ThreeActivity");
				intent.setComponent(cName);
				MainActivity.this.startActivity(intent);
			
			}
		});
		
		findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_CALL);
				// �趨���� Uri.parse()����һ���ַ�������Uri����
				intent.setData(Uri.parse("tel:10086"));
				MainActivity.this.startActivity(intent);
			}
		});
	}
}
