package com.zyh.android.vieweventsdemo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnTouchListener{

	// Collection-->List Set
	
	// View������¼�
	// ����¼�(onClick) �����¼�(longClick) �����¼�(onTouch)
	// ��һ����ͼ���ü���
	// 1.�Ҷ���
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//		view.findViewById(id);// ��View����Ӧ����ͼ��������ȥ��ָ��id�Ŀؼ�
		View view = this.findViewById(R.id.button); // ��ҳ�������صĲ�������ȥ��ָ����id�ؼ�
		Button button = (Button)view;// ǿ��ת�� ����ת��
//		TextView textView = (TextView)view;
		
		// coll-->ArrayList@368462
//		Collection<String> coll = new ArrayList<String>();
//		List<String> list = (List<String>) coll;
		// ���ü�����ʽ�޷Ǿ��ǵ��������set����
		// OnTouchListenerһ���ӿ�
		
		// 1.ͨ�������ڲ���ķ�ʽ
//		button.setOnTouchListener(new View.OnTouchListener() {			
//			@Override
//			public boolean onTouch(View v, MotionEvent event) {
//				return false;
//			}
//		});
		
		// 2.ͨ����ķ�ʽʵ��
//		button.setOnTouchListener(new MyTouch());
//		// 3.ͨ�������ڲ���ʵ�� ���������Խ�����
		button.setOnTouchListener(touchListener);
//		// 4.����ʵ��
//		button.setOnTouchListener(this);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				System.out.println("����¼�");
			}
		});
		
		button.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				System.out.println("�����¼�");
				// ����true��ʾ���ش˼���������֮�����¼����ᴥ��
				return true;
			}
		});
	}
	
	private View.OnTouchListener touchListener = new View.OnTouchListener() {			
		@Override // ����ͼ���������¼���Ӧ 1.��ǰ�¼����������(��ͼ����) 2.�¼�������Ҫ�ṩ��ǰ�¼�����������Ȳ�����
		// ���������ֵ���������ͼ������˵
		public boolean onTouch(View v, MotionEvent event) {
			int action = event.getAction();// ��ȡ�¼�����
			float x = event.getX();
			float y = event.getY();// ��ȡ��ǰ������(�������ͼ)
			switch (action) {
			case MotionEvent.ACTION_DOWN:// �����¼�
				System.out.println("����....................x:"+x+",y:"+y);
				break;
			case MotionEvent.ACTION_MOVE:// �ƶ��¼�
				System.out.println("�ƶ�....................x:"+x+",y:"+y);
				break;
			case MotionEvent.ACTION_UP:// �ɿ��¼�
				System.out.println("�ɿ�....................x:"+x+",y:"+y);
				break;
			}
			// ����ֵ��ʾ�Ƿ����ش˼�����true��ʾ���أ�����֮�󣬵���ͳ����¼������ܴ���
			return false;
		}
	};
	
	private class MyTouch implements View.OnTouchListener{
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			return false;
		}
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		System.out.println("����ҳ��Ĵ����¼�");
		return true;
	}
}
