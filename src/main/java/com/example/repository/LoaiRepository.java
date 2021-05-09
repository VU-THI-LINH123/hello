package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Response.HangxeResponse;
import com.example.Response.LoaiResponse;
import com.example.entity.Loaixe;
@Repository
public interface LoaiRepository extends JpaRepository<Loaixe, Long> {
	@Query("SELECT new com.example.Response.LoaiResponse(entity) FROM Loaixe as entity")
	List<LoaiResponse>danhsachloai();

}
