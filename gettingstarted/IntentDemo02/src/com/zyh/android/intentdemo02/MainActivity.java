package com.zyh.android.intentdemo02;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
	
	// Extra ���������

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}
	
	public void startClick(View view){
		Intent intent = new Intent(this, TargetActivity.class);
		intent.putExtra("num", 10);
		intent.putExtra("str", "Hello nihaoma");
		// 1. Bundle ��HashMap���� ��������--
		//    ��ֵ�� Map�ļ�ֵ�Զ��Ƿ��� Bundle��key����String����
		//    HashMapʵ�ֵ���Serializable Bundleʵ�ֵ���Parcelable   
		
		// Serializable ���л��ӿ�
		// ���л��� �����ݻ��߶��󱣴����ļ�����(ObjectOutputStream)
		// �����л��� ���ļ����潫���ݶ�����(ObjectInputStream)
		// Parcelable �ӿ� �ǽ����ݻ��߶��󱣴����ڴ�����
		Bundle bundle = new Bundle();
		bundle.putString("name", "����");
		intent.putExtra("bundle", bundle);
		
		// Serializable ArrayList LinkedList HashSet HashMap
		ArrayList<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		intent.putExtra("list", list);
		// Parcelable Bundle
		// �Զ�����������
		startActivity(intent);
	}
}
