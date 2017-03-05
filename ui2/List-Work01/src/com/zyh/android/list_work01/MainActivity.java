package com.zyh.android.list_work01;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView listView;
	private MessageAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		listView = (ListView) findViewById(R.id.listView);
		adapter = new MessageAdapter(this, getData());
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				adapter.setRead(position, true);
			}
		});
	}
	 
	private List<MessageBean> getData(){
		List<MessageBean> data = new ArrayList<MessageBean>();
		for (int i = 0; i < 10; i++) {
			MessageBean mb = new MessageBean();
			mb.setTitle("��������һ��ͨ����֪ͨ");
			mb.setTime("2015-12-20");
			mb.setContent("�������Ǿͻ�ȡһ����/test.do��ַ��HTTP������,���Ǵ�ӡcon��class������ʵ��:sun.net.www.protocol.http.HttpURLConnection�����,������д������������������ʱ�ͻᷢ�����ǻ����OutOfMemoryError�Ĵ���,��Ȼ��ͬ�Ļ����ϳ��ִ�������Ӧ���ļ�������Ĵ�С�ǲ�һ����.�����Ҫ����ȡ���ڱ�����JVM���ڴ�ռ�Ĵ�С��.");
			mb.setRead(false);
			mb.setSender("��������");
			mb.setReceiver("����");
			mb.setId(i);
			data.add(mb);
		}
		return data;
	}
}
