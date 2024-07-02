package com.quiz.booking.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.booking.domain.Booking;

@Mapper
public interface BookingMapper {
	
	public List<Booking> selectBookingList();
	
	public int deleteBookingById(int id);
	
	public void insertBookingList(
			@Param("name") String name,
			@Param("day") int day,
			@Param("date") LocalDate date,
			@Param("headcount") int headcount,
			@Param("phoneNumber") String phoneNumber
			);

	public List<Booking> selectBookingByNamePhoneNumber(
			@Param("name") String name, 
			@Param("phoneNumber")String phoneNumber
			);

}
