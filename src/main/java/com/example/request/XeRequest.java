package com.example.request;

import java.util.Set;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.Data;

public class XeRequest {
	private Long id;
	
    private String ten;
    private String antoan;
    private String tienghi;
    private Set<AnhRequest>anhRequests;
    private LoaiRequest loaiRequest;
    private HangxeRequest hangxeRequest;
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
	public String getAntoan() {
		return antoan;
	}
	public void setAntoan(String antoan) {
		this.antoan = antoan;
	}
	public String getTienghi() {
		return tienghi;
	}
	public void setTienghi(String tienghi) {
		this.tienghi = tienghi;
	}
	public Set<AnhRequest> getAnhRequests() {
		return anhRequests;
	}
	public void setAnhRequests(Set<AnhRequest> anhRequests) {
		this.anhRequests = anhRequests;
	}

	public LoaiRequest getLoaiRequest() {
		return loaiRequest;
	}
	public void setLoaiRequest(LoaiRequest loaiRequest) {
		this.loaiRequest = loaiRequest;
	}
	public HangxeRequest getHangxeRequest() {
		return hangxeRequest;
	}
	public void setHangxeRequest(HangxeRequest hangxeRequest) {
		this.hangxeRequest = hangxeRequest;
	}
    
}
