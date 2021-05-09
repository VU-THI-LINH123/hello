package com.example.request;
public class LoaiRequest {
	  private Long id;
	   private String ten;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public LoaiRequest(Long id, String ten) {
		super();
		this.id = id;
		this.ten = ten;
	}
	public LoaiRequest() {
		super();
	}
	   
}
