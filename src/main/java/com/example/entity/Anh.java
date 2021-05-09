package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Anh")
@Data
public class Anh {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
   private Long id;
    @Column
	private String ten;
    @ManyToOne
    @JoinColumn(name = "xe_id")
    private Xe xe;
	  
}
