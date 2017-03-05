package com.zyh.android.intentdemo04;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void buttonClick(View view){
		Person person = new Person("����", "�Ĵ��ɶ�", 22);
		Intent intent = new Intent();
		// �Զ����Person�����е������������涼û���ҵ�
		// 1. ʵ��Serializable�ӿ�
		// 2. ʵ��Parcelable
		//    ʵ������2�����󷽷���describeContents writeToParcel
		//    ����Parcelable�ڲ��ӿ�Creator������. д�������� public static final Parcelable.Creator CREATOR = new ....
		//    
		Person2 person2 = new Person2("����", "�Ĵ��ɶ�", 22);
		intent.putExtra("Person", person);
		intent.putExtra("Person2", person2);
		intent.setClass(this, TargetActivity.class);
		startActivity(intent);
	}
}
