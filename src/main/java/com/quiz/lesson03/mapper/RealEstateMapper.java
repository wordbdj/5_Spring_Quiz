package com.quiz.lesson03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.lesson03.domain.RealEstate;

@Mapper
public interface RealEstateMapper {

	public RealEstate selectRealEstateById(int id);
	public List<RealEstate> selectRealEstateListByRentPrice(int rentPrice);
	
	// mapper interface가 xml로 parameter 전송시 1개만 보낼 수 있다.
	// @Param annotation을 사용하면 parameter를 하나의 맵으로 구성해준다
	public List<RealEstate> selectRealEstatListeByAreaPrice(
			@Param("area") int area,
			@Param("price") int price);
	
	public int insertRealEstate(RealEstate realEstate);
	public int insertRealEstateByField(
			@Param("realtorid") int realtorid,
			@Param("address") String address,
			@Param("area") int area,
			@Param("type") String type,
			@Param("price") int price,
			@Param("rentPrice") int rentPrice);
	
	public int updateRealEstateById(
			@Param("id") int id, 
			@Param("type") String type, 
			@Param("price") int price);
	
	public int deleteRealEstateById(int id);
}
