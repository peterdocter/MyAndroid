package com.zyh.android.startactivity4result;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	// ҳ���ջ 
	// ��ջ �Ƚ����  A1-->B-->A2-->C A1-->B(����A1������BҪ�Ӷ�ջ����)-->C A1(����)-->B(����)-->A1
	// startActivityForResult ��ת��Ϊ�˻�ȡһ�����
	// ���� �Ƚ��ȳ�
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	/**
	 * ע�ᰴť�ļ����¼�
	 * @param view
	 */
	public void registerClick(View view){
		Intent intent = new Intent(this, ResultActivity.class);
		intent.putExtra("jisuan", "1 + 1 = ?");
		// 1.��ת��Intent���� ��������ת��ComponentName, Extra
		// 2.RequestCode ������ ������������Ψһֵ
		startActivityForResult(intent, 100);
	}
	
	@Override // ���н�����ص�ʱ�򶼻���Ӧ�˷���
	// 1.requestCode �����ŵ�Ψһֵ����Ϊ��Activity��������е�startActivityForResult�ķ��ض�����Ӧ�˷���
	//   ���������������������ķ���������һ�����󷢳���
	// 2.resultCode �����š���Ҫ�жϵ��ǽ���Ƿ���ȷ�ķ��ء�һ����˵�����������ȷ��ֵΪActivity.RESULT_OK
	//   �����п�����Activity.RESULT_CANCEL
	// 3.data ������ش��ݵĲ���
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Log.d("zhou", "..onActivityResult..");
		if(resultCode == RESULT_OK){ // �����ȷ
			switch (requestCode) {
			case 100: // ��ʾ�˽����requestCodeΪ100��������󷢳���
				Toast.makeText(MainActivity.this, "��������1 + 1 = " + data.getStringExtra("result"), Toast.LENGTH_SHORT).show();
				break;
			default:
				break;
			}
		}
	}
}
