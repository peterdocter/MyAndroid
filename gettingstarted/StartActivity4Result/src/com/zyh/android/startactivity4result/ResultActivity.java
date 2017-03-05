package com.zyh.android.startactivity4result;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class ResultActivity extends Activity{

	private EditText inputEdit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);
		
		inputEdit = (EditText) findViewById(R.id.resultEdit);
	}
	
	/**
	 * ȷ����ť�ļ���
	 * @param view
	 */
	public void sureClick(View view){
		Log.d("zhou", "..sureClick..�����ȷ����ť");
		String result = inputEdit.getText().toString();
		// ��װ����
		Intent data = new Intent();
		data.putExtra("result", result);
		// ��������з���
		// 1. ������صı�ţ�һ�������������ȷ���ֵд��Activity.RESULT_OK
		//    �������������򷵻�:Activity.RESULT_CANCELED
		// 2. ���ݵ�����
		// ������setResult��ʱ��ͻ���Ӧ���������Activity�����onActivityResult����
		// ͨ���������ٴ�ҳ��
		setResult(Activity.RESULT_OK, data);
		this.finish(); // ����ҳ��
	}
}
