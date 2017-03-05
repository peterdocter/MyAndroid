package com.zyh.android.listview_singlechoice;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends Activity {

	// �б�����ĵ�ѡ����
	private ListView listView;
	private SingleChoiceAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		/*************��ʼ������***************/
		List<String> data = new ArrayList<String>();
		data.add("��ɫ");
		data.add("��ɫ");
		data.add("��ɫ");
		data.add("��ɫ");
		data.add("��ɫ");
		data.add("��ɫ");
		data.add("��ɫ");
		data.add("��ɫ");
		data.add("��ɫ");
		data.add("��ɫ");
		data.add("��ɫ");
		data.add("��ɫ");
		data.add("��ɫ");
		data.add("��ɫ");
		data.add("��ɫ");
		data.add("��ɫ");
		data.add("��ɫ");
		data.add("��ɫ");
		data.add("��ɫ");
		data.add("��ɫ");
		data.add("��ɫ");
		
		listView = (ListView) findViewById(R.id.listView);
		adapter = new SingleChoiceAdapter(this, data);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				adapter.setChoiceId(position);
			}
		});
	}
}
