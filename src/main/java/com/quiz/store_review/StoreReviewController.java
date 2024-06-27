package com.quiz.store_review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson02.bo.StoreBO;
import com.quiz.lesson02.domain.Store;
import com.quiz.store_review.bo.ReviewBO;
import com.quiz.store_review.domain.Review;

@RequestMapping("/store-review")
@Controller
public class StoreReviewController {

	@Autowired
	private StoreBO storeBO;
	
	@Autowired
	private ReviewBO reviewBO;
	
	// 1. 가게 목록 화면
	@RequestMapping("/store-list-view")
	public String storeList(Model model) {
		List<Store> storeList = storeBO.getStore();
		model.addAttribute("storeList", storeList);
		
		return "store_review/storeList";
	}
	
	// 2. 리뷰 화면
	@RequestMapping("/review-view")
	public String review(
			@RequestParam("storeId") int storeId,
			@RequestParam("storeName") String storeName,
			Model model) {
		
		List<Review> reviewList = reviewBO.getReviewByStoreId(storeId);
		model.addAttribute("reviewList", reviewList);
		model.addAttribute("storeName", storeName);
		
		return "store_review/review";
	}
}