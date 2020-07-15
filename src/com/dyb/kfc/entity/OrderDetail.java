package com.dyb.kfc.entity;

/**
 * @author 星之梦
 *
 */
public class OrderDetail {
	private int id;
	private int oid;// 订单
	private int mid;// 餐品id

	public OrderDetail() {
		super();
	}

	public OrderDetail(int id, int oid, int mid) {
		super();
		this.id = id;
		this.oid = oid;
		this.mid = mid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

}