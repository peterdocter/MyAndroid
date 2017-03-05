package com.zyh.android.intentdemo01;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {
	
	// Intent
	// 1. ��ʾ��ת ��ȷ��֪��Ҫ��ת��ҳ�� ����Intent �趨ComponentName Context.startActivity
	// 2. ��ʽ��ת Action Data Type(Category ����)
	
	// Intent.ACTION_VIEW ��Ҫϵͳ��һ��ҳ������ʾָ�������� data, type
	// type ָ����MIME���� image/png *��ʾ���������

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	// 1.View ��ʾ��ǰ��������¼�����ͼ����
	public void showImage(View view){
//		IntentFilter
		// ����Intent���� 1.��������actionֵ
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(null); // ��������
		intent.setType(""); // ������������
		// Uri��ʾͬһ��Դ��ʶ�� http://(��··��) file://(������·��) content://(ContentProvider)
		// http://www.baidu.com/index.html
		// Environment.getExternalStorageDirectory() ��ȡ���濨�ĸ�Ŀ¼
		String filePath = Environment.getExternalStorageDirectory().getAbsolutePath()+"/Pictures/sample_7.jpg";
		Log.d("zhou", "..showImage..sdcard·����"+Environment.getExternalStorageDirectory().getAbsolutePath());
		// �ж��ļ��Ƿ����
		File file = new File(filePath);
		if(file.exists()){
			// ��ͬʱҪ�������ݺ�����ʱֻ�ܹ�ʹ������ķ���
			intent.setDataAndType(Uri.parse("file://" + filePath), "image/*"); // �������ݺ�����
			MainActivity.this.startActivity(intent);
		}else{
			Log.d("zhou", "..showImage..�ļ�������");
		}

	}
	
	public void buttonClick(View view){
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_VIEW);
		intent.addCategory(Intent.CATEGORY_DEFAULT);
		String filePath = Environment.getExternalStorageDirectory().getAbsolutePath()+"/Pictures/sample_7.jpg";
		intent.setDataAndType(Uri.parse("file://" + filePath), "image/*"); // �������ݺ�����
		startActivity(intent);
	}
}
