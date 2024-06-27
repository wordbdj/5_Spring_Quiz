package com.quiz.store_review.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.quiz.store_review.domain.Review;

@Mapper
public interface ReviewMapper {
	public List<Review> selectReviewByStoreId(int storeId);
}