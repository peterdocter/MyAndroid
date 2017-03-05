package com.zyh.android.listmultiitemdemo;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MultiItemAdapter extends BaseAdapter{

	// item������ֵ������С��item����������
	public static final int TYPE_COUNT = 2;
	public static final int TYPE_LEFT = 0;
	public static final int TYPE_RIGHT = 1;
	
	private LayoutInflater mInflater;
	private List<MessageEntity> data;
	public MultiItemAdapter(Context context, List<MessageEntity> data){
		this.mInflater = LayoutInflater.from(context);
		this.data = data;
	}
	
	@Override
	public int getCount() {
		return data == null ? 0 : data.size();
	}

	@Override
	public MessageEntity getItem(int position) {
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override // 2.convertView��ʾ�����ظ�ʹ�õ���ͼ����
	// �ظ�ʹ�õ������ǣ�1. convertView != null 2.item������һ��
	public View getView(int position, View convertView, ViewGroup parent) {
		// 1.��Ҫ�Ȼ�ȡ��item������
		int type = getItemViewType(position);
		if(convertView == null){
			switch (type) { // ��������ת��ָ������ͼ
			case TYPE_LEFT:
				convertView = mInflater.inflate(R.layout.item_left, parent, false);
				break;
			case TYPE_RIGHT:
				convertView = mInflater.inflate(R.layout.item_right, parent, false);
				break;
			}
		}
		
		switch (type) {
		case TYPE_LEFT:
			TextView descView = (TextView) convertView.findViewById(R.id.desc);
			descView.setText("������������");
			break;
		}
		
		ImageView headImgView = (ImageView) convertView.findViewById(R.id.headImg);
		TextView timeView = (TextView) convertView.findViewById(R.id.time);
		TextView contentView = (TextView) convertView.findViewById(R.id.content);
		
		// �趨����
		MessageEntity messageEntity = getItem(position); // ��ȡָ���±��Ӧ�����ݶ���
		timeView.setText(messageEntity.getTime());
		contentView.setText(messageEntity.getContent());
		
		return convertView;
	}
	
	@Override // ����ָ���±�item������
	public int getItemViewType(int position) {
		return getItem(position).getType();
	}

	// ����item������ĸ���
	public int getViewTypeCount() {
        return TYPE_COUNT;
    }
}
