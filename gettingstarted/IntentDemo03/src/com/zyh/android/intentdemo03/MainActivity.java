package com.zyh.android.intentdemo03;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	// ��һ��ҳ�棺ȡ������������ EditText.getText().toString();
	// 1.��ʽ��ת
	// 2.��ʽ��ת 
	
	private EditText editText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		editText = (EditText) findViewById(R.id.inputEdit);
		findViewById(R.id.button).setOnClickListener(onClick);
	}
	
	private View.OnClickListener onClick = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			// 1.�Ȼ�ȡ����������
			String str = editText.getText().toString();
			Log.d("zhou", "..onClick..str:"+str);
			// 2.����Intent����
			/**************��ʾ��ת**************/
//			Intent intent = new Intent();
//			// ������ת�����  1. Context 2.��ת��������֣���+����
//			intent.setComponent(new ComponentName(MainActivity.this, "com.zyh.android.intentdemo03.TargetActivity"));
//			// ���ô�������
//			intent.putExtra("text", str);
//			// ������ת
//			MainActivity.super.startActivity(intent);
			/**************��ʽ��ת**************/
			// ��ϵͳ����û���κ�һ��ҳ����Խ��մ��ݵ�Intent(action data type category),���׳��쳣
			Intent intent = new Intent();// action data(Uri) type category
//			intent.setAction("com.zyh.android.intentdemo03.ACTION");
			intent.setAction(Intent.ACTION_VIEW);
			// ���ô�������
			intent.putExtra("text", str); // ���ݵĶ�������
			intent.setType("text/plain");
			try{
				MainActivity.super.startActivity(intent);
			}catch(Exception e){
				e.printStackTrace();
				Log.d("zhou", "..onClick..û��ҳ����Խ��մ�Intent");
			}
			
		}
	};
}
