package com.example.service.impl;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.Response.ListXeResponse;
import com.example.Response.ResultResponse;
import com.example.Response.XeResponse;
import com.example.common.Validate;
import com.example.entity.Anh;
import com.example.entity.Hangsanxuat;
import com.example.entity.Loaixe;
import com.example.entity.Xe;
import com.example.repository.AnhRepository;
import com.example.repository.HangsanxuatPository;
import com.example.repository.LoaiRepository;
import com.example.repository.Xerepository;
import com.example.request.AnhRequest;
import com.example.request.UpdateXeRequest;
import com.example.request.XeRequest;
import com.example.request.XeSearchResponse;
import com.example.service.XeService;
import com.example.xception.CustomException;
@Service
@Transactional
public class XeServiceimpl implements XeService {
	@Autowired
	EntityManager manager;
	private static final Logger LOGGER = LoggerFactory.getLogger(XeServiceimpl.class);
	public ResultResponse searchByPage(XeSearchResponse xeSearchResponse) {
	   
		int pageIndex = xeSearchResponse.getPageIndex();
		int pageSize = xeSearchResponse.getPageSize();

		if (pageIndex > 0) {
			pageIndex--;
		} else {
			pageIndex = 0;
		}

		String whereClause = "";
		
		String orderBy = " ORDER BY entity.id DESC";
		if (Validate.isNotEmptyString(xeSearchResponse.getOrderBy())) {
		
			orderBy = " ORDER BY entity."+xeSearchResponse.getOrderBy()+" ASC";
		}
		
		String sqlCount = "select count(entity.id) from Xe as entity where (1=1)";
		String sql = "select new com.example.Response.XeResponse(entity) from Xe as entity where (1=1)";

		if (Validate.isNotEmptyString(xeSearchResponse.getKeyword())) {
			whereClause += " AND (UPPER(entity.ten) LIKE UPPER(:text)) OR (UPPER(entity.loaixe.ten) LIKE UPPER(:text))OR(UPPER(entity.hangsanxuat.ten) LIKE UPPER(:text))";
		}
		
		sql += whereClause + orderBy;
		sqlCount += whereClause;
        
		Query q = manager.createQuery(sql,XeResponse.class);
		
		
		Query qCount = manager.createQuery(sqlCount);

		if (Validate.isNotEmptyString(xeSearchResponse.getKeyword())) {
			q.setParameter("text", '%' + xeSearchResponse.getKeyword() + '%');
			qCount.setParameter("text", '%' +xeSearchResponse.getKeyword() + '%');
		}
		 
		int startPosition = pageIndex * pageSize;
		q.setFirstResult(startPosition);
		q.setMaxResults(pageSize);
		List<XeResponse> entities = q.getResultList();
		long count = (long) qCount.getSingleResult(); 
		Pageable pageable = PageRequest.of(pageIndex, pageSize);
		Page<XeResponse> result = new PageImpl<XeResponse>(entities, pageable, count);
		
		ListXeResponse listCompanyResponse = new ListXeResponse(result.getContent(),result.getTotalElements(),result.getPageable());
		return ResultResponse.builder()
				.statusCode(200)
				.messageCode("api.success")
				.message("Success!")
				.result(listCompanyResponse)
				.build();
	}
	@Autowired
	HangsanxuatPository hangsanxuatPository;
	@Autowired
	Xerepository xerepository;
	@Autowired
	LoaiRepository loaiRepository;
	public void validateNewxeRequest(XeRequest newxeRequest) throws CustomException {
		//validate newCompanyRequest
			
				if(Validate.isEmptyString(newxeRequest.getTen())) {
					LOGGER.warn("ten xe is null!");
					throw new CustomException(ResultResponse.STATUS_CODE_BAD_REQUEST, ResultResponse.MESSEGE_TEN_NULL_CAR , ResultResponse.MESSEGE_NULL_CARNAME);
				}
				if(Validate.isEmptyString(newxeRequest.getAntoan())) {
					LOGGER.warn("an is null!");
					throw new CustomException(ResultResponse.STATUS_CODE_BAD_REQUEST, ResultResponse.MESSEGE_CODE_NULL_ANTOAN , ResultResponse.MESSEGE_NULL_ANTOAN);
				}
				if(Validate.isEmptyString(newxeRequest.getTienghi())) {
					LOGGER.warn("tien ghi is null!");
					throw new CustomException(ResultResponse.STATUS_CODE_BAD_REQUEST, ResultResponse. MESSEGE_CODE_NULL_TIENGHI, ResultResponse.MESSEGE_NULL_TIENGHI);
				}
				
				
				}
	public ResultResponse addCompany(XeRequest xeRequest) throws CustomException {
		validateNewxeRequest(xeRequest);
		Xe xe= new Xe();
		xe.setTen(xeRequest.getTen());
		xe.setTienghi(xeRequest.getTienghi());
		xe.setAntoan(xeRequest.getAntoan());
        
		Hangsanxuat hangsanxuat = hangsanxuatPository.findById(xeRequest.getHangxeRequest().getId()).orElse(null);
	    if(hangsanxuat==null)
	    {
	    	throw new CustomException(ResultResponse.STATUS_CODE_BAD_REQUEST, ResultResponse.MESSEGE_CODE_EXSIT_COMPANYCODE, ResultResponse.MESSEGE_EXSIT_COMPANYCODE);
	    }
	  
	    Loaixe loaixe=loaiRepository.findById(xeRequest.getLoaiRequest().getId()).orElse(null);
	    if(loaixe==null)
	    {
	    	throw new CustomException(ResultResponse.STATUS_CODE_UNAUTHORIZED, ResultResponse.MESSEGE_CODE_EXSIT_COMPANYCODE, ResultResponse.MESSEGE_EXSIT_COMPANYCODE);
	    }
        xe.setHangsanxuat(hangsanxuat);
        xe.setLoaixe(loaixe);
        if(xeRequest.getAnhRequests()!=null)
        {
        	Set<Anh>danhsach=new HashSet<Anh>();
        	for(AnhRequest t:xeRequest.getAnhRequests())
        	{
        		Anh m=new Anh();
        		m.setTen(t.getUrl());
        		m.setXe(xe);
        		danhsach.add(m);
        	}
        	xe.setAnhs(danhsach);
        }
        
		Xe hi=xerepository.save(xe);
		
		return   ResultResponse.builder()
				.statusCode(ResultResponse.STATUS_CODE_SUCCESS)
				.messageCode(ResultResponse.MESSEGE_CODE_SUCCESS)
				.message(ResultResponse.MESSEGE_SUCCESS)
				.result(new XeResponse(hi))
				.build();		
	}
	@Autowired
	AnhRepository anhRepository;
	public ResultResponse updateXe(UpdateXeRequest updateXeRequest) throws CustomException {
		Xe xe = xerepository.findById(updateXeRequest.getId()).orElse(null);
		
		if(xe == null) {
			throw new CustomException(ResultResponse.STATUS_CODE_BAD_REQUEST, ResultResponse.MESSEGE_CODE_NOT_EXIST_EMPLOYEECODE, ResultResponse.MESSEGE_NOT_EXIST_EMPLOYEECODE);
		}
		Loaixe loaixe =loaiRepository.findById(updateXeRequest.getLoaiRequest().getId()).orElse(null);
		if(loaixe == null) {
			throw new CustomException(ResultResponse.STATUS_CODE_BAD_REQUEST, ResultResponse.MESSEGE_CODE_NOT_EXIST_COMPANY, ResultResponse.MESSEGE_NOT_EXIST_COMPANY);
		}
		 xe.setLoaixe(loaixe);
		Hangsanxuat hangsanxuat =hangsanxuatPository.findById(1l).orElse(null);
		if(hangsanxuat == null) {
			throw new CustomException(ResultResponse.STATUS_CODE_BAD_REQUEST, ResultResponse.MESSEGE_CODE_NOT_EXIST_COMPANY, ResultResponse.MESSEGE_NOT_EXIST_COMPANY);
		}
	     xe.setHangsanxuat(hangsanxuat);
		if(Validate.isNotEmptyString(updateXeRequest.getTen())) {
		  xe.setTen(updateXeRequest.getTen());
		}
		if(Validate.isNotEmptyString(updateXeRequest.getAntoan())) {
			xe.setAntoan(updateXeRequest.getAntoan());
		}
	   if(updateXeRequest.getDongco()!=0)
	   {
	    xe.setDongco(updateXeRequest.getDongco());
	   }
	 
	    if(updateXeRequest.getAnhRequests().size()>0)
	    {
	    	for(Anh t:xe.getAnhs())
	    	{
	    		anhRepository.delete(t);
	    	}
	    	Set<Anh> danhsach=new HashSet<Anh>();
	    	for(AnhRequest m:updateXeRequest.getAnhRequests())
	    	{
	    		Anh anh=new Anh();
	    		anh.setTen(updateXeRequest.getTen());
	    		anh.setXe(xe);
	    		danhsach.add(anh);
	    	}
	    	xe.setAnhs(danhsach);
	    }
		Xe kq=xerepository.save(xe);
		return ResultResponse.builder()
				.statusCode(ResultResponse.STATUS_CODE_SUCCESS)
				.messageCode(ResultResponse.MESSEGE_CODE_SUCCESS)
				.message(ResultResponse.MESSEGE_SUCCESS)
				.result(new XeResponse(kq))
				.build();
	}
	public ResultResponse delete(List<Long> ids) throws Exception{
		if(ids.size()>0) {
			Set<Xe>danhsach=new HashSet<Xe>();
			 for(Long id:ids)
			 {
				 Xe xe=xerepository.findById(id).orElse(null);
				 if(xe==null)
				 {
					 throw new CustomException(ResultResponse.STATUS_CODE_BAD_REQUEST, ResultResponse.MESSEGE_CODE_NOT_EXIST_COMPANY, ResultResponse.MESSEGE_NOT_EXIST_COMPANY); 
				 }
				 danhsach.add(xe);
			 }	
			 for(Xe xe:danhsach)
			 {
				 xerepository.delete(xe);
			 }
		   }
		return ResultResponse.builder()
				.statusCode(ResultResponse.STATUS_CODE_SUCCESS)
				.messageCode(ResultResponse.MESSEGE_CODE_SUCCESS)
				.message(ResultResponse.MESSEGE_SUCCESS)
				.build();
	}
}
