package com.example.Response;

import java.util.HashSet;
import java.util.Set;
import com.example.entity.Anh;
import com.example.entity.Loaixe;
import com.example.entity.Xe;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class XeResponse {
	
	private Long id;
    private String ten;
    private String antoan;
    private String tienghi;
    private Set<AnhResponse>anhResponses;
    private LoaiResponse loaiResponse;
    private HangxeResponse hangxeResponse;

	public XeResponse(Xe xe) {
			this.id=xe.getId();
			this.ten=xe.getTen();
			this.antoan=xe.getAntoan();
			this.tienghi=xe.getTienghi();
			 if(xe.getAnhs().size()>0)
		     {
		    	 anhResponses=new HashSet<AnhResponse>();
		    	 for(Anh a:xe.getAnhs())
		    	 {
		    		 if(a!=null && a.getId()!=null)
		    		 {
		    			 anhResponses.add(new AnhResponse(a));
		    		 }
		    	 }
		     }
			if(xe.getHangsanxuat()!=null && xe.getHangsanxuat().getId()!=null)
			{
				hangxeResponse=new HangxeResponse(xe.getHangsanxuat());
			}
			if(xe.getLoaixe()!=null && xe.getLoaixe().getId()!=null)
			{
				loaiResponse=new LoaiResponse(xe.getLoaixe());
			}
		}
	
	}

