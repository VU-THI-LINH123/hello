package com.example.Response;

import com.example.entity.Anh;
import com.example.entity.Xe;
import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class AnhResponse {
	
	private Long id;
    private String url;
	public AnhResponse(Anh anh) {
		if(anh!=null) {
			this.id=anh.getId();
			this.url=anh.getTen();
		}
	}
    
}
