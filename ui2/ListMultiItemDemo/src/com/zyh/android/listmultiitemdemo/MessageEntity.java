package com.zyh.android.listmultiitemdemo;

/**
 * ��Ϣʵ����
 * 
 * @author Administrator
 */
public class MessageEntity {

	private int id; // ��Ϣ��id
	private String sender; // ������
	private String receiver; // ������
	private String content; // ����
	private String time; // ������ʱ��
	private String imgPath; // ͷ���·��
	/**
	 * 0��ʾ���˷��� TYPE_LEFT
	 * 1��ʾ�Լ����� TTPE_RIGHT
	 */
	private int type = -1; // ���� ��Ҫָ�����Ƿ����Լ�������

	public MessageEntity() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
}
