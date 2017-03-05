package com.zyh.android.expandablelistviewdemo;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseExpandableListAdapter{

	private List<HashMap<String, String>> groupData;
	private List<List<HashMap<String, String>>> childData;
	private LayoutInflater mInflater;
	public MyAdapter(Context context, List<HashMap<String, String>> groupData, List<List<HashMap<String, String>>> childData) {
		this.mInflater = LayoutInflater.from(context);
		this.groupData = groupData;
		this.childData = childData;
	}
	
	@Override // ������ĸ���
	public int getGroupCount() {
		return groupData == null ? 0 : groupData.size();
	}

	@Override // ����ָ�����Ӧ�����б�����
	public int getChildrenCount(int groupPosition) {
		return childData.get(groupPosition).size();
	}

	@Override// ������
	public Object getGroup(int groupPosition) {
		return groupData.get(groupPosition);
	}

	@Override // ������
	public Object getChild(int groupPosition, int childPosition) {
		return groupPosition;
	}

	@Override // ��id
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override // ��id
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override // ͬ����id�Ƿ�����ͬ��������
	public boolean hasStableIds() {
		return false;
	}

	@Override // ����ͼ 1.���±� 2.������Ƿ񱻴�
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.group_layout, parent, false);
		}
		// �ҿؼ�
		TextView textView = (TextView) convertView.findViewById(R.id.groupName);
		textView.setText(groupData.get(groupPosition).get("GroupName"));
		
		ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
		imageView.setImageResource(isExpanded ? R.drawable.list_icn_order_up : R.drawable.list_icn_order_down);
		return convertView;
	}

	@Override // ����ͼ
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView,
			ViewGroup parent) {
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.child_layout, parent, false);
		}
		// �ҿؼ�
		TextView textView = (TextView) convertView.findViewById(R.id.childName);
		textView.setText(childData.get(groupPosition).get(childPosition).get("ChildName"));
		TextView dataView = (TextView) convertView.findViewById(R.id.childData);
		dataView.setText(childData.get(groupPosition).get(childPosition).get("ChildData"));
		return convertView;
	}

	@Override // ���б��Ƿ���Ա�ѡ��
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}

}
