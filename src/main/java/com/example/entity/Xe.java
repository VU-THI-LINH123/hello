package com.example.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
@Entity
@Table(name = "xe")

public class Xe {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
   private Long id;
	
	@Column
	
	private String ten;
	@Column 
	private String antoan;
	@Column 
	private String tienghi;
	   @Column
	   private int socua;
	   @Column
	   private int  soghe;
	   @Column
	   private int dongco;
	   @Column
	   private int dungtichsilanh;
	   @Column
	   private int hethongnapnhienlieu;
	   @Column
	   private String mucnapnhieulieu;
	 @ManyToOne
	 @JoinColumn(name = "loai_id")
	 private  Loaixe loaixe;
	 @ManyToOne
	 @JoinColumn(name = "hangsanxuat_id")
	 private  Hangsanxuat hangsanxuat;
	 @OneToMany(mappedBy = "xe", cascade = CascadeType.ALL)
	   private Set<Anh>anhs;
	 
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
	public Loaixe getLoaixe() {
		return loaixe;
	}
	public void setLoaixe(Loaixe loaixe) {
		this.loaixe = loaixe;
	}
	public Hangsanxuat getHangsanxuat() {
		return hangsanxuat;
	}
	public void setHangsanxuat(Hangsanxuat hangsanxuat) {
		this.hangsanxuat = hangsanxuat;
	}
	public Set<Anh> getAnhs() {
		return anhs;
	}
	public void setAnhs(Set<Anh> anhs) {
		this.anhs = anhs;
	}
	
	public Xe(Long id, String ten, String antoan, String tienghi, int socua, int soghe, int dongco, int dungtichsilanh,
			int hethongnapnhienlieu, String mucnapnhieulieu, Loaixe loaixe, Hangsanxuat hangsanxuat, Set<Anh> anhs) {
		super();
		this.id = id;
		this.ten = ten;
		this.antoan = antoan;
		this.tienghi = tienghi;
		this.socua = socua;
		this.soghe = soghe;
		this.dongco = dongco;
		this.dungtichsilanh = dungtichsilanh;
		this.hethongnapnhienlieu = hethongnapnhienlieu;
		this.mucnapnhieulieu = mucnapnhieulieu;
		this.loaixe = loaixe;
		this.hangsanxuat = hangsanxuat;
		this.anhs = anhs;
	}
	public Xe() {
		super();
	}
		 
	
}
