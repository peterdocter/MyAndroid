package com.ayh.android.example02;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
		
		// Context Application(��ʵ��) Activity Service
		TextView textView = new TextView(getApplication());
		textView.setBackgroundResource(android.R.color.holo_blue_bright);
		textView.setText("Hello ���");
		
		// ����һ���յĶ����������մ��ڵ�����
		DisplayMetrics displayMetrics = new DisplayMetrics();
		getWindow().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		
		// LayoutParams����ÿһ��ViewGroup����ӵ��һ����̬�ڲ���
		// ѡ��˭Ӧ�ø��ݱ���ӵ��ĸ��ؼ�������
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int)(200 * displayMetrics.density), -1);
//		textView.setLayoutParams(layoutParams);
		
		LinearLayout linearLayout = new LinearLayout(this);
		linearLayout.setOrientation(LinearLayout.VERTICAL);
	
		// textView����ӵ�Ĭ�ϴ�С��wrap_content
		linearLayout.addView(textView, layoutParams);
//		 һ���ؼ�ֻ�ܹ������һ�Σ������Ҫ���ʹ�ã���Ӧ���ȴ����ĸ��ؼ����潫���Ƴ�֮������ٴ����
		linearLayout.removeAllViews();// �Ƴ������������еĿؼ�
		linearLayout.removeView(textView);// �Ƴ�ָ������ͼ
		linearLayout.addView(textView);
		
		TextView textView2 = new TextView(getApplication());
		textView2.setBackgroundResource(android.R.color.holo_orange_dark);
		textView2.setText("��ð�");
		// 1.�Ǳ���ӵ���ͼ���� 2.��ӵ�λ�� 0��ʾ��һ��
		linearLayout.addView(textView2, 0);
		
		linearLayout.setBackgroundResource(android.R.color.holo_red_light);
		setContentView(linearLayout);
	}
}
