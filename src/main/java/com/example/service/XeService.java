package com.example.service;

import java.util.List;

import com.example.Response.ResultResponse;
import com.example.request.UpdateXeRequest;
import com.example.request.XeRequest;
import com.example.request.XeSearchResponse;
import com.example.xception.CustomException;

public interface XeService {
	public ResultResponse searchByPage(XeSearchResponse xeSearchResponse);
	public ResultResponse addCompany(XeRequest xeRequest)throws CustomException ;
	public ResultResponse updateXe(UpdateXeRequest updateXeRequest)throws CustomException ;
	public ResultResponse delete(List<Long> ids) throws Exception;
}
