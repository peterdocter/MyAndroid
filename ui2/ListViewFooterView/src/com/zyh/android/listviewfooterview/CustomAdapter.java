package com.zyh.android.listviewfooterview;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter{
	
	private LayoutInflater mInflater; // �������� ת����ͼ
	private List<MessageInfo> data; // �б���ʾ������
	public CustomAdapter(Context context, List<MessageInfo> data) {
		this.mInflater = LayoutInflater.from(context);
		this.data = data;
	}

	@Override // ����item�ĸ���
	public int getCount() {
		return data == null ? 0 : data.size();
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
	
	/**
	 * ���һ��������
	 * @param newData
	 */
	public void addAll(List<MessageInfo> newData){
		if(this.data == null){
			data = new ArrayList<MessageInfo>();
		}
		data.addAll(newData);
		notifyDataSetChanged();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;
		if(convertView == null){
			holder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.item_list, parent, false);
			holder.textView1 = (TextView) convertView.findViewById(R.id.text1);
			holder.textView2 = (TextView) convertView.findViewById(R.id.text2);
			holder.textView3 = (TextView) convertView.findViewById(R.id.text3);
			holder.textView4 = (TextView) convertView.findViewById(R.id.text4);
			holder.textView5 = (TextView) convertView.findViewById(R.id.text5);
			holder.textView6 = (TextView) convertView.findViewById(R.id.text6);
			// ����holder����
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		// ������ʾ������
		MessageInfo mi = data.get(position); // ȡ��item��Ӧ�����ݶ���
		holder.textView1.setText(mi.getPalyer()); // ѡ��
		holder.textView2.setText(mi.getEvent()); // ��������
		holder.textView3.setText(mi.getCode()); // ��Ʊ����
		holder.textView4.setText(mi.getName()); // ��Ʊ����
		holder.textView5.setText(mi.getType()); // ��������
		holder.textView6.setText(String.valueOf(mi.getCount())); // ��������
		return convertView;
	}

	private class ViewHolder{
		private TextView textView1, textView2, textView3, textView4, textView5, textView6;
	}
}
