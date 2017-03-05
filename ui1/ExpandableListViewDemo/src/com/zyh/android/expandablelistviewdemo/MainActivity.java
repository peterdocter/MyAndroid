package com.zyh.android.expandablelistviewdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.SimpleExpandableListAdapter;

public class MainActivity extends Activity {

	// 1.ExpandableListView �����б���ͼ
	
	private ExpandableListView expandableListView;
	public static final String DATASTR1 = "This child is even";
	public static final String DATASTR2 = "This child is odd";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		expandableListView = (ExpandableListView) findViewById(R.id.listView);
		
		// ��װ������
		List<HashMap<String, String>> groupData = new ArrayList<HashMap<String, String>>();
		for (int i = 0; i < 20; i++){
			HashMap<String, String> groupMap = new HashMap<String, String>();
			groupMap.put("GroupName", "Group "+(i));
			groupData.add(groupMap);
		}
		// ��װ���б�����
		List<List<HashMap<String, String>>> childData = new ArrayList<List<HashMap<String,String>>>();
		int groupSize = groupData.size(); // ��Ĵ�С
		for (int i = 0; i < groupSize; i++){ // ÿһ�����Ӧһ��List<Map>����
			List<HashMap<String, String>> childListData = new ArrayList<HashMap<String,String>>();
			// ��ÿһ����������б�����
			for (int j = 0; j < 15; j++){
				HashMap<String, String> childMap = new HashMap<String, String>();
				childMap.put("ChildName", "Child "+(0));
				childMap.put("ChildData", j % 2 == 0 ? DATASTR1 : DATASTR2);
				childListData.add(childMap);
			}
			childData.add(childListData); // ���ÿһ��������
		}
		
		// 1.Context ������
		// 2.List<? extends Map<String, ?>> groupData ������ size��ʾһ���ж�����
		// 3.LayoutResId expandedGroupLayout �鱻��ʱ��ʾ�Ĳ���
		// 4.LayoutResId collapsedGroupLayout �鱻�ر�ʱ��ʾ�Ĳ���
		// 5.String[] groupFrom Ҫ���鲼������Ŀؼ��������ݵ�key����
		// 6.int[] groupTo �鲼��������Ҫ�������ݵĿؼ���id����
		// 7.List<List<? extends Map<String, ?>>>  childData.size��ʾ�ܹ��ж��ٸ���������� ��һ��List�Ĵ�С
		//   childData.get(groupPosition) ��ʾָ�����Ӧ�����б�����
		// 8.LayoutResId childLayout �Ӳ���
		// 9.String[] childFrom Ҫ���Ӳ�������Ŀؼ��������ݵ�key����
		// 10.int[] groupTo �Ӳ���������Ҫ�������ݵĿؼ���id����
		SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(this,
				groupData, R.layout.group_layout, R.layout.group_layout, 
				new String[]{"GroupName"}, new int[]{R.id.groupName}, childData, 
				R.layout.child_layout, new String[]{"ChildName", "ChildData"}, new int[]{R.id.childName, R.id.childData});
		
		MyAdapter myAdapter = new MyAdapter(this, groupData, childData);
		expandableListView.setAdapter(myAdapter);
		expandableListView.setGroupIndicator(null);
		
		// ������Ĺرռ���
		expandableListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {
			@Override
			public void onGroupCollapse(int groupPosition) {
				Log.d("zhou", "..onGroupCollapse..���رյ�����±꣺"+groupPosition);
			}
		});
		
		// ������Ĵ򿪼���
		expandableListView.setOnGroupExpandListener(new OnGroupExpandListener() {
			@Override
			public void onGroupExpand(int groupPosition) {
				Log.d("zhou", "..onGroupExpand..�鱻�򿪵��±�:"+groupPosition);
			}
		});
		
		// ��ĵ������
		expandableListView.setOnGroupClickListener(new OnGroupClickListener() {
			@Override // ����true��ʾ�����¼��� ������¼��ͽ��ղ���
			public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
				Log.d("zhou", "..onGroupClick..���µ�����±꣺"+groupPosition);
				return false;
			}
		});
		
		// ���б��������
		expandableListView.setOnChildClickListener(new OnChildClickListener() {
			@Override
			public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
				Log.d("zhou", "..onChildClick..���б�������������飺"+groupPosition+",�ڼ�����"+childPosition);
				return false;
			}
		});
	}
}
