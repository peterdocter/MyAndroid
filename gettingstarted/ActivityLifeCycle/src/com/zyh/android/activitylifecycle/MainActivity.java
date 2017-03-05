package com.zyh.android.activitylifecycle;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	// Activity����������
	// ҳ��Ӵ���������Ҫ�����Ĳ��裺
	
	// ���豸�������л�ʱҳ����������ڻ�����ִ�С�
	
	private TextView messageView;
	
	@Override // Bundle savedInstanceState �����ҳ�����
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d("zhou", "MainActivity..onCreate..");
		messageView = (TextView) findViewById(R.id.message);
		if(savedInstanceState != null){
			// ��ȡ�������ɫֵ�� ���key�������򷵻�-1
			int color = savedInstanceState.getInt("Color", -1);
			if (color != -1){
				messageView.setTextColor(color);
			}
		}
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.d("zhou", "MainActivity..onStart..");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.d("zhou", "MainActivity..onRestart..");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.d("zhou", "MainActivity..onResume..");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.d("zhou", "MainActivity..onPause..");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.d("zhou", "MainActivity..onStop..");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d("zhou", "MainActivity..onDestroy..");
	}
	
	@Override // ����ҳ��״̬ �˷�������onPause��onStop֮��ִ��
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		Log.d("zhou", "MainActivity..onSaveInstanceState..:");
		outState.putInt("Color", Color.RED);// ����һ����ɫֵ
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		Log.d("zhou", "..onConfigurationChanged..");
	}
	
	public void jumpClick(View view){
		Intent intent = new Intent(Intent.ACTION_DIAL);
		intent.setData(Uri.parse("tel:80000"));
//		Intent intent = new Intent(this, TwoActivity.class);
		startActivity(intent);
		messageView.setTextColor(Color.RED);
	}
}
