package com.zyh.android.listview_singlechoice;

import java.util.ArrayList;
import java.util.List;

import com.zyh.android.listview_singlechoice.SingleChoiceAdapter.OnRadioButtonClickListener;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	// �б�����ĵ�ѡ����
	private ListView listView;
	private SingleChoiceAdapter adapter;
	private TextView textView;
	private String source;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		/*************��ʼ������***************/
		final List<String> data = new ArrayList<String>();
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
		// ���ݽӿڶ���
		adapter.setOnRadioButtonClickListener(listener3);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				adapter.setChoiceId(position);
				// ȡ��item��Ӧ������
				String str = data.get(position);
				// ��������
				textView.setText(source+"��"+str);
			}
		});
		
		textView = (TextView) findViewById(R.id.message);
		source = textView.getText().toString(); // ȡ��TextViewĬ����ʾ������
	}
	
	public void updateText(String text){
		// ��������
		textView.setText(source+"��"+text);
	}
	
	private OnRadioButtonClickListener listener = new OnRadioButtonClickListener() {
		@Override
		public void onRadioButtonClick(String str) {
			Log.d("zhou", "..onRadioButtonClick..str:"+str);
			// ��������
			textView.setText(source+"��"+str);
		}
	};
	
	private OnRadioButtonClickListener listener2 = new OnRadioButtonClickListener() {
		@Override
		public void onRadioButtonClick(String str) {
			Log.d("zhou", "..onRadioButtonClick..str:"+str);
			// ��������
			textView.setText(source+"��"+str);
		}
	};
	
	private OnRadioButtonClickListener listener3 = new OnRadioButtonClickListener() {
		@Override
		public void onRadioButtonClick(String str) {
			Log.d("zhou", "..onRadioButtonClick..str:"+str);
			// ��������
			textView.setText(source+"��"+str);
		}
	};
}
