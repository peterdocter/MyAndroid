package com.zyh.android.helloworld;

import com.zyh.android.helloworld2222.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;

public class TwoActivity extends Activity {

	// ͼƬ �ı� ��ɫ ��Ƶ ��Ƶ
	// 1.5~2.x �����ֻ�ϵͳ
	// 3.x ƽ��ϵͳ
	// 4.0���� �ֻ���ƽ�嶼������
	
	// assets�� res�����Ŷ�����Դ
	// res �������Դ�ڴ����ʱ�򶼻ᱻ�����2���Ƹ�ʽ��res����Դ���Զ���R�ļ�����������ʵ���Ͼ���R�ļ������˹���res��Դ��id
	// assets����������ǲ��ᱻ���룬Ҳ�����R�ļ�������������ȡֻ��ͨ�����ķ�ʽ��
	
	// res��Դ��
	// drawable-->ͼƬ mipmap(studio)��
	// layout--������Դ ��ʾ���ֻ��ϵ�ҳ��Ч��
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		DisplayMetrics displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		Log.d("HelloWorld", "dpi:"+displayMetrics.densityDpi);
		Log.d("HelloWorld", "�ܶ�:"+displayMetrics.density);
	}
}
