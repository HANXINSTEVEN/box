package com.oracle.entity;

public class Product {
	private String name;//��Ʒ��
	private String address;//����
	private String price;//�۸�
	private String imagine;//ͼƬ��ַ
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getImagine() {
		return imagine;
	}
	public void setImagine(String imagine) {
		this.imagine = imagine;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", address=" + address + ", price="
				+ price + "]";
	}
	

}
