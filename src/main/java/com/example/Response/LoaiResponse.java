package com.example.Response;

import com.example.entity.Loaixe;

import lombok.Data;

@Data
public class LoaiResponse {
	   private Long id;
	   private String ten;
	public LoaiResponse(Loaixe loaixe) {
		if(loaixe!=null && loaixe.getId()!=null)
		{
			this.id=loaixe.getId();
			this.ten=loaixe.getTen();
		}
	}
	   
}
