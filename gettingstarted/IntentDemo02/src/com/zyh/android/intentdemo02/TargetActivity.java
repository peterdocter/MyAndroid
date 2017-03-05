package com.zyh.android.intentdemo02;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class TargetActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_target);
		
		Intent intent = getIntent();
		// 1.key 2.Ĭ��ֵ ���ǵ�key�����ڷ��ص�ֵ
		int num = intent.getIntExtra("num", -1);
		String str = intent.getStringExtra("str");
		Bundle bundle = intent.getBundleExtra("bundle");
		String name = bundle.getString("name");
		ArrayList<String> list = (ArrayList<String>) intent.getSerializableExtra("list");
		Log.d("zhou", "..onCreate..num:"+num+"\nstr:"+str+"\nname:"+name+"\nlist:"+list);
		
	}
}
