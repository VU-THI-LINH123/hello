package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Anh;
@Repository
public interface AnhRepository  extends JpaRepository<Anh, Long> {

}
