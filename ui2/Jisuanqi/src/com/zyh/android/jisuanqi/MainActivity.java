package com.zyh.android.jisuanqi;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends Activity {

	private int width = 0;
	public static final String[][] BUTTON_NAMES = {{"7","8","9","/"},{"4","5","6","*"},{"1","2","3","-"},{".","0","=","+"}};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 
		// ����һ���յ�point����
		Point point = new Point();
		Log.d("zhou", "..onCreate.��ȡǰ.point.x:"+point.x+", point.y:"+point.y);
		// getSize��ȡ��Ļ�Ĵ�С������Ĵ�Сָ������Ļ�ķֱ���
		getWindowManager().getDefaultDisplay().getSize(point);
		Log.d("zhou", "..onCreate.��ȡ��.point.x:"+point.x+", point.y:"+point.y);
		width = point.x / 4;
		Log.d("zhou", "..onCreate..1/4�Ŀ�"+width);
		// �ҵ�����
		TableLayout parentView = (TableLayout) findViewById(R.id.container);
		// 4��
		for(int i = 0; i < 4; i++){
			// ÿһ��Ҫ����һ��TableRow
			TableRow tableRow = new TableRow(this);
			// 4��
			for(int j = 0; j < 4; j++){
				// ÿһ�д���һ����ť
				TextView button = createButton(10*(i+1)+j, BUTTON_NAMES[i][j]);
				// ����ť��ӵ�tableRow����
				tableRow.addView(button);
			}
			parentView.addView(tableRow);
		}
		// �ҵ�ɾ����ť
		TextView deleteView = (TextView) findViewById(R.id.deleteButton);
		deleteView.setWidth(width - 7);
		
	}
	
	private TextView createButton(int id, String text){
		TextView button = new TextView(this);
		// ���õĲ��ֲ���
		TableRow.LayoutParams params = new TableRow.LayoutParams(width, width);
		button.setLayoutParams(params);
		params.leftMargin = 1;
		params.rightMargin = 1;
		params.topMargin = 1;
		params.bottomMargin = 1;
		// �����ı�
		button.setText(text);
		// ����id
		button.setId(id);
		// ���ü���
		button.setOnClickListener(buttonClick);
		// �����ı���С
		button.setTextSize(30);
		// ���ñ���
		button.setBackgroundResource(android.R.color.darker_gray);
		// ��������
		button.setGravity(Gravity.CENTER);
		
		return button;
	}
	
	private View.OnClickListener buttonClick = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			int id = v.getId();
			switch (id) {
			case 10: // 
				
				break;

			default:
				break;
			}
		}
	};
}
