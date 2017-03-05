package com.zyh.android.listview_singlechoice;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

public class SingleChoiceAdapter extends BaseAdapter{

	private List<String> data;
	private LayoutInflater mInflater;
	private int choiceId = -100; // ��¼ѡ�е��±�
	public SingleChoiceAdapter(Context context, List<String> data){
		this.data = data;
		this.mInflater = LayoutInflater.from(context);
	}
	
	@Override
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
	
	public int getChoiceId() {
		return choiceId;
	}

	public void setChoiceId(int choiceId) {
		// ���ε������ͬһ���±� �򲻲���
		if (this.choiceId == choiceId){
			return;
		}
		this.choiceId = choiceId;
		this.notifyDataSetChanged();
	}

	@Override // �ռ任ʱ�� �����ڴ滻ȡЧ��
	public View getView(final int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;
		if(convertView == null){ // ��ʾconvertView�ж��ٸ��¶�����ôViewHolder���ж��ٸ��¶���
			holder = new ViewHolder();
			// �����µ�convertView����
			convertView = mInflater.inflate(R.layout.item_singlechoice, parent, false);
			// �ҿؼ�
			holder.textView = (TextView) convertView.findViewById(R.id.text1);
			holder.rb = (RadioButton) convertView.findViewById(R.id.radioButton);
			// ����holder����
			convertView.setTag(holder);
		}else {
			// ȡ��convertView���汣���tag����ֵ
			holder = (ViewHolder)convertView.getTag();
		}
		
		// ��������
		holder.textView.setText(data.get(position));
		// ����RadioButton��ѡ��״̬
		// ����±����ѡ�е��±�������ѡ��״̬
		holder.rb.setChecked(position == choiceId);
		// ��RadioButton���õ���¼�
		holder.rb.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				setChoiceId(position);
			}
		});
		
		return convertView;
	}

	private class ViewHolder{
		private TextView textView;
		private RadioButton rb;
//		private Object tag;
//		
//		public Object getTag() {
//			return tag;
//		}
//		public void setTag(Object tag) {
//			this.tag = tag;
//		}
	}
}
