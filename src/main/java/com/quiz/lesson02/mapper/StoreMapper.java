package com.quiz.lesson02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.quiz.lesson02.domain.Store;

@Mapper
public interface StoreMapper { // String bean 등록
	
	// input: X
	// output: (BO로 가는) List<Store>
	
	public List<Store> selectStore();
	
}
