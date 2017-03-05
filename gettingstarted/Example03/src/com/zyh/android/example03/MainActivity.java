package com.zyh.android.example03;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView textView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		textView = (TextView) findViewById(R.id.textView);
//		findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				
//			}
//		});
	}
	
	
	/**
	 * ͨ��xml�ķ���ע�ᰴť�ļ���
	 * @param view
	 */
	public void buttonClick(View view){
		Log.d("zhou", "..buttonClick..�����ť");
		// �޸��ı������ݺ���ɫ
		textView.setText("�޸ĵ��ı�");// �趨�ı�������
		// int colorָ�Ĳ�����color��idֵ��������ɫֵ
		Resources res = getResources();// �õ�res��Դ������
		int blueColor = res.getColor(R.color.blue);// ��ȡ��Ӧ��ɫ��int����ֵ
		textView.setTextColor(blueColor);
	}
}
