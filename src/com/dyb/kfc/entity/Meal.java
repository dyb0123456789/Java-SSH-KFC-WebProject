package com.dyb.kfc.entity;

/**
 *
 * Title: Meal
 *
 * Description:
 *
 *
 *
 */
public class Meal {
	private int id;
	private String mname;
	private double price;
	private String remark;
	private String mimg;

	public Meal() {
		super();
	}

	public Meal(int id, String mname, double price, String remark, String mimg) {
		super();
		this.id = id;
		this.mname = mname;
		this.price = price;
		this.remark = remark;
		this.mimg = mimg;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getMimg() {
		return mimg;
	}

	public void setMimg(String mimg) {
		this.mimg = mimg;
	}

}
