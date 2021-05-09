package com.example.request;
public class HangxeRequest {
	private Long id;
    private  String ten;
   
    private String diachi;

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

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public HangxeRequest(Long id, String ten, String diachi) {
		super();
		this.id = id;
		this.ten = ten;
		this.diachi = diachi;
	}

	public HangxeRequest() {
		super();
	}
	
    
}
