package com.example.controller;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Response.HangxeResponse;
import com.example.Response.LoaiResponse;
import com.example.Response.ResultResponse;
import com.example.repository.HangsanxuatPository;
import com.example.repository.LoaiRepository;
import com.example.request.UpdateXeRequest;
import com.example.request.XeRequest;
import com.example.request.XeSearchResponse;
import com.example.service.XeService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController      
@RequestMapping(path = "/api/sanpham")
public class Xecontroller {
	
	@Autowired
    XeService xeService;
	@Autowired
	LoaiRepository loaiRepository;
	@PostMapping("/search")
	 public ResultResponse searchByPage(@RequestBody XeSearchResponse  searchDto)  {
			return xeService.searchByPage(searchDto);
     }
	@PostMapping("/add")
	public ResultResponse addCompany(@Valid @RequestBody XeRequest xeRequest) throws Exception 
	{
	     return xeService.addCompany(xeRequest);    
	}
	
	@PutMapping("")
	public ResultResponse updateXe(@RequestBody UpdateXeRequest updateXeRequest) throws Exception{
		return xeService.updateXe(updateXeRequest);
	}
	@DeleteMapping("/{ids}")
	public ResultResponse deleteCompany(@PathVariable("ids") List<Long> ids) throws Exception{

		return xeService.delete(ids);
	}
	@GetMapping("/loai")
	 public ResponseEntity<List<LoaiResponse>> searchloai()  {
			return  new ResponseEntity<>(loaiRepository.danhsachloai(), HttpStatus.OK);
    }
	@Autowired HangsanxuatPository hangsanxuatPository;
	@GetMapping("/hangsanxuat")
	 public ResponseEntity<List<HangxeResponse>> searchhang()  {
			return  new ResponseEntity<>(hangsanxuatPository.danhsachloai(), HttpStatus.OK);
   }	
}

