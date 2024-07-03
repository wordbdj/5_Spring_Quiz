package com.quiz.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.bo.CompanyBO;
import com.quiz.lesson07.entity.CompanyEntity;

@RestController
@RequestMapping("/lesson07/quiz01")
public class Lesson07Quiz01RestController {
	
	@Autowired
	private CompanyBO companyBO;
	
	@GetMapping("/save1")
	public CompanyEntity save1() {
		String name = "넥손";
		String business = "컨텐츠 게임";
		String scale = "대기업";
		int headcount = 3585;
		
		return companyBO.addCompany(name, business, scale, headcount);
	}

	@GetMapping("/save2")
	public CompanyEntity save2() {

		
		return companyBO.addCompany("버블팡", "여신 금융업", "대기업", 6834);
	}
	
	@GetMapping("/update")
	public CompanyEntity update() {
		
		return companyBO.updateScaleHeadcountById(8, "중소기업", 34);
	}
	
	@GetMapping("/delete")
	public String delete() {
		
		companyBO.deleteCompanyById(8);
		
		return "수행 완료";
	}
	
}
