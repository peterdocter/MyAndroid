package com.zyh.android.activitylaunchmode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_c);
		findViewById(R.id.textView).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				textViewClick(v);
			}
		});
	}
	
	public void textViewClick(View view){
		Intent intent = new Intent(this, AActivity.class);
		// FLAG_ACTIVITY_CLEAR_TOP ��������ת��ָ��ҳ��ʱ�� ָ��ҳ�����ϵ�����ҳ�涼�ᱻ����
		// ���������ڣ�singleTask
//		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		intent.putExtra("boo", true);
		startActivity(intent);
	}
}
