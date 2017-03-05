package com.zyh.android.example01;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	// View ��ʾ��ͼ
	// ViewGroup ��ͼ�� �κο��������ͼ�Ķ���������ViewGroup�����࣬LinearLayout, RelativeLayout
	// ViewGroup.LayoutParams ���ֲ���(���ߣ����ĵ�����)
	// ViewGroup.addView �����ͼ
	

	@Override // ��ʾҳ���ڴ�����ʱ�����
	// onCreate������Activity�������ڵ�����һ������
	// ����Activity������������ڷ�����������ø���ķ��� ��������쳣
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// ����������ͼ ����ҳ����ʾ�Ķ���
		setContentView(R.layout.activity_main);// ����Ĳ�����һ��������Դid
		
		DisplayMetrics displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		System.out.println("�ܶ�ֵ��"+displayMetrics.density);
		
//		Context ������ (1)application + (n)activity + (n)service
		Application applicatin = getApplication();
		Context context = getApplicationContext();
		System.out.println("application:"+applicatin);
		System.out.println("context:"+context);
		TextView textView = new TextView(this);// ����TextView����
		textView.setText("Hello �����");
		textView.setText(R.string.hello_world);// �ַ�����Դid
		textView.setText(String.valueOf(3));
		textView.setBackgroundResource(android.R.color.holo_blue_light);
		textView.setWidth(200);
		setContentView(textView);
		
		// 1.width  2.height

		
		// 200ָ������ֵ
		ViewGroup.LayoutParams params = new ViewGroup.LayoutParams((int)(200 * displayMetrics.density), -1);
		setContentView(textView, params);
	}
}
