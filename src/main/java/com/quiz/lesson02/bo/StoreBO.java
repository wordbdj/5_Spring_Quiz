package com.quiz.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson02.domain.Store;
import com.quiz.lesson02.mapper.StoreMapper;

@Service
public class StoreBO { // String bean 등록
	

	@Autowired
	public StoreMapper storeMapper;

	// input: X
	// output: (RestController로 가는) List<Store>
	
	public List<Store> getStoreList() {
		
		return storeMapper.selectStoreList();
		
	}
}
