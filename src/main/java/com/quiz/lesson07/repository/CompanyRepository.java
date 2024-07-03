package com.quiz.lesson07.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.lesson07.entity.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer> {

	public Optional<CompanyEntity> findById(int id);
	
}
