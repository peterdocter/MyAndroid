package com.zyh.android.work_loginregister;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity{

	private EditText accountEdit, pwdEdit, birthdayEdit, addressEdit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		
		accountEdit = (EditText) findViewById(R.id.account);
		pwdEdit = (EditText) findViewById(R.id.password);
		birthdayEdit = (EditText) findViewById(R.id.birthday);
		addressEdit = (EditText) findViewById(R.id.address);
	}
	
	/**
	 * ע�ᰴť�ĵ���¼�
	 * @param view
	 */
	public void registerClick(View view){
		String account = accountEdit.getText().toString();
		String password = pwdEdit.getText().toString();
		String birthday = birthdayEdit.getText().toString();
		String address = addressEdit.getText().toString();
		// �ȼ���˺ź������Ƿ�������
		if ("".equals(account) || "".equals(password)){
			Log.d("zhou", "..registerClick..�������˺Ż�������");
			Toast.makeText(this, "�������˺Ż�������", Toast.LENGTH_SHORT).show();
			return;
		}
		// �����ݷ�װ��JavaBean
		RegisterInfo registerInfo = new RegisterInfo(account, password, birthday, address);
		Intent intent = new Intent();
		intent.setComponent(new ComponentName(this, LoginActivity.class));
		// ��װ������Intent����
		intent.putExtra("Data", registerInfo);
		this.startActivity(intent);
	}
}
