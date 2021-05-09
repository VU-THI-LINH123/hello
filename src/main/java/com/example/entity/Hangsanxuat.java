package com.example.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name = "Hangsanxuat")
public class Hangsanxuat {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
   private Long id;
    @Column
	private String ten;
    @Column
	private String diachi;
    @OneToMany(mappedBy = "hangsanxuat", cascade = CascadeType.ALL)
	   private Set<Xe>xes;
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
	public Set<Xe> getXes() {
		return xes;
	}
	public void setXes(Set<Xe> xes) {
		this.xes = xes;
	}
    
}
