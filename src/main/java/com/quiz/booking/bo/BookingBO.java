package com.quiz.booking.bo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.booking.domain.Booking;
import com.quiz.booking.mapper.BookingMapper;

@Service
public class BookingBO {

	@Autowired
	public BookingMapper bookingMapper;
	
	public List<Booking> getBookingList() {
		
		return bookingMapper.selectBookingList();
	}
	
	public int deleteById(int id) {
		
		return bookingMapper.deleteBookingById(id);
	}
	
	public void addBookingList(String name, int day, LocalDate date, int headcount, String phoneNumber) {
		
		bookingMapper.insertBookingList(name, day, date, headcount, phoneNumber);
	}

	// input:name, phoneNumber
	//output: Booking(최신) or null
	
	public Booking getLatestBookingByNamePhoneNumber(String name, String phoneNumber) {
		
		// 없을때 []   있을때 [booking1, booking2]
		
		List<Booking> bookingList = bookingMapper.selectBookingByNamePhoneNumber(name, phoneNumber);
		
//		if (bookingList.isEmpty()) {
//			return null;
//		}
		
		
		return bookingList.isEmpty() ? null : bookingList.get(bookingList.size() - 1);
		
		
	}
}
