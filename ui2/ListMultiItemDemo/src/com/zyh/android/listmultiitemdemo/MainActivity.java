package com.zyh.android.listmultiitemdemo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity {

	// ��item����
	// getCount getItem getItemId getView
	
	// 1.��ѡ 2.��ѡ 3.FooterView,HeaderView 4.��item���� 5.EmptyView
	
	private MultiItemAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ListView listView = (ListView) findViewById(R.id.listView);
		adapter = new MultiItemAdapter(this, initData());
		listView.setAdapter(adapter);
//		listView.setSelection(position);// �趨ѡ����һ��
	}
	
	public static String getNowTime(){
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date());
	}
	
	private List<MessageEntity> initData(){
		List<MessageEntity> data = new ArrayList<MessageEntity>();
		for (int i = 0; i < 10; i++){
			MessageEntity messageEntity = new MessageEntity();
			messageEntity.setTime(getNowTime());// ���õ�ǰʱ��
			messageEntity.setContent("Hello �����?");
			messageEntity.setId(i); 
			messageEntity.setType(i % 2); // ��������
			data.add(messageEntity);
		}
		return data;
	}
}
