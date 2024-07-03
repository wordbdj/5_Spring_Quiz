package com.quiz.lesson07;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.entity.RecruitEntity;
import com.quiz.lesson07.repository.RecruitRepository;

@RequestMapping("/lesson07/quiz02")
@RestController
public class Lesson07Quiz02RestController {

	@Autowired
	private RecruitRepository recruitRepository;
	
	@GetMapping("/1")
	public Optional<RecruitEntity> quiz01_1() {
		// id가 8인 공고를 조회
		
		return recruitRepository.findById(8);
	}
	
	@GetMapping("/2")
	public List<RecruitEntity> quiz01_2(
			@RequestParam("id") int id) {
		// id가 8인 공고를 조회
		
		return recruitRepository.findById(id);
	}
	
	@GetMapping("/3")
	public List<RecruitEntity> quiz01_2(
			@RequestParam("id") int id) {
		// id가 8인 공고를 조회
		
		return recruitRepository.findById(id);
	}
	
	@GetMapping("/4")
	public List<RecruitEntity> quiz01_2(
			@RequestParam("id") int id) {
		// id가 8인 공고를 조회
		
		return recruitRepository.findById(id);
	}
	
	@GetMapping("/5")
	public List<RecruitEntity> quiz01_2(
			@RequestParam("id") int id) {
		// id가 8인 공고를 조회
		
		return recruitRepository.findById(id);
	}
	@GetMapping("/6")
	public List<RecruitEntity> quiz01_2(
			@RequestParam("id") int id) {
		// id가 8인 공고를 조회
		
		return recruitRepository.findById(id);
	}
	
	
}
