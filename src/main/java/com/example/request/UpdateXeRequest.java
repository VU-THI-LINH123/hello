package com.example.request;
import java.util.Set;
public class UpdateXeRequest {
	private Long id;
    private String ten;
    private String antoan;
    private String tienghi;
	private int socua;
	private int  soghe;
	private int dongco;
    private int dungtichsilanh;
	private int hethongnapnhienlieu;
	private String mucnapnhieulieu;
    private Set<AnhRequest>anhRequests;
    private LoaiRequest loaiRequest;
    private HangxeRequest hangxeRequest;
    
	public int getSocua() {
		return socua;
	}
	public void setSocua(int socua) {
		this.socua = socua;
	}
	public int getSoghe() {
		return soghe;
	}
	public void setSoghe(int soghe) {
		this.soghe = soghe;
	}
	public int getDongco() {
		return dongco;
	}
	public void setDongco(int dongco) {
		this.dongco = dongco;
	}
	public int getDungtichsilanh() {
		return dungtichsilanh;
	}
	public void setDungtichsilanh(int dungtichsilanh) {
		this.dungtichsilanh = dungtichsilanh;
	}
	public int getHethongnapnhienlieu() {
		return hethongnapnhienlieu;
	}
	public void setHethongnapnhienlieu(int hethongnapnhienlieu) {
		this.hethongnapnhienlieu = hethongnapnhienlieu;
	}
	public String getMucnapnhieulieu() {
		return mucnapnhieulieu;
	}
	public void setMucnapnhieulieu(String mucnapnhieulieu) {
		this.mucnapnhieulieu = mucnapnhieulieu;
	}
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
