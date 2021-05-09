package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Response.HangxeResponse;
import com.example.Response.LoaiResponse;
import com.example.entity.Hangsanxuat;
@Repository
public interface HangsanxuatPository extends JpaRepository<Hangsanxuat, Long> {
	@Query("SELECT new com.example.Response.HangxeResponse(entity) FROM Hangsanxuat as entity")
	List<HangxeResponse>danhsachloai();
	
}
