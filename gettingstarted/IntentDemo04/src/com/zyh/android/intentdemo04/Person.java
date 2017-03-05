package com.zyh.android.intentdemo04;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class Person implements Parcelable{

	private String name;
	private String address;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", address=" + address + ", age=" + age + "]";
	}

	public Person(String name, String address, int age) {
		super();
		this.name = name;
		this.address = address;
		this.age = age;
	}

	public Person() {
		super();
	}
	
	private Person(Parcel source){
		// ��ȡ���ݵ�˳���Ǻ�д���˳��һ��
		this.name = source.readString(); // ��ȡ����
		this.address = source.readString();// ��ȡ��ַ
		this.age = source.readInt(); // ��ȡ����
	}

	@Override // û��ʲô���� Ĭ�Ϸ��ؾͿ�����
	public int describeContents() {
		return 0;
	}

	@Override // ������д�뵽�ڴ�����
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(name); // д����
		dest.writeString(address); // д��ַ
		dest.writeInt(age); // д����
		Log.d("zhou", "..writeToParcel..д������");
	}

	public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>() {

		@Override // �ӱ�����ڴ��ȡ���� 1.����Ĳ������Ǳ��������ݵĶ���
		public Person createFromParcel(Parcel source) {
			Log.d("zhou", "..createFromParcel..��ȡ����");
			return new Person(source);
		}

		@Override // ����ָ���������͵�����
		public Person[] newArray(int size) {
			return new Person[size];
		}
	};
}
