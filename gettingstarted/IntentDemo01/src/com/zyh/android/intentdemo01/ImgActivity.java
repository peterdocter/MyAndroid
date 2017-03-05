package com.zyh.android.intentdemo01;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

public class ImgActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_img);
		
		Intent intent = getIntent();// ��ȡ��ת����ҳ���Intent����
		Uri uri = intent.getData(); // ��ȡ���ݵ�����
		if(uri != null){
			ImageView imgView = (ImageView) findViewById(R.id.image);
			imgView.setImageURI(uri);// ����ͼƬ����ԴΪһ��uriֵ
		}
	}
}
