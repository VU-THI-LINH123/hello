package com.example.Response;

import com.example.entity.Hangsanxuat;

import lombok.Data;

@Data
public class HangxeResponse {
	private Long id;
    private  String ten;
   
    private String diachi;
	public HangxeResponse(Hangsanxuat hangsanxuat) {
		if(hangsanxuat!=null && hangsanxuat.getId()!=null)
		{
			this.id=hangsanxuat.getId();
			this.ten=hangsanxuat.getTen();
			this.diachi=hangsanxuat.getDiachi();
			
		}
	}
    
}
