package com.quiz.booking;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.booking.bo.BookingBO;
import com.quiz.booking.domain.Booking;

@RequestMapping("/booking")
@Controller
public class BookingController {

	@Autowired
	public BookingBO bookingBO;
	
	@GetMapping("/booking-list-view")
	public String bookingListView(Model model) {
		
		// DB search
		List<Booking> booking = bookingBO.getBookingList();
		// Model
		model.addAttribute("booking", booking);
		// return
		return "booking/bookingList";
		
	}
	
	@ResponseBody
	@DeleteMapping("/delete-by-id")
	public Map<String, Object> deleteById(
			@RequestParam("id") int id) {
		
		// DB delete
		int rowCount = bookingBO.deleteById(id);
		
		// AJAX send
		Map<String, Object> result = new HashMap<>();
		if (rowCount > 0) {
			result.put("code", 200);
			result.put("result","성공" );
			} else {
				result.put("code", 500);
				result.put("error_message", "삭제할 항목이 존재하지 않습니다.");
			}
		
		return result;
	}
	
	
	@GetMapping("/make-booking-view")
	public String makeBookingView() {
		
		return "booking/makeBookingView";
	}
	
	// AJAX 요청 -> insert DB
	@ResponseBody
	@PostMapping("/make-booking")
	public Map<String, Object> makeBooking(
			@RequestParam("name") String name
			,@RequestParam("day") int day
			,@RequestParam("date") LocalDate date
			,@RequestParam("headcount") int headcount
			,@RequestParam("phoneNumber") String phoneNumber) {
		
		// DB insert
		bookingBO.addBookingList(name, day, date, headcount, phoneNumber);
		
		// 성공 JSON
				// {"code":200, "result":"성공"}
				Map<String, Object> result = new HashMap<>();
				result.put("code", 200);
				result.put("result", "성공");
				return result;
		}

	
	
	
	
	@GetMapping("/check-booking-view")
	public String checkBookingView() {
		
		return "booking/checkBookingView";
	}
	
	
	// AJAX 요청 -> select DB
	@ResponseBody
	@PostMapping("/check-booking")
	public Map<String, Object> checkBooking(
			@RequestParam("name") String name
			, @RequestParam("phoneNumber") String phoneNumber) {
		
		// DB select 
		Booking bookingList =  bookingBO.checkBookingByNamePhoneNumber(name, phoneNumber); 
		
		Map<String, Object> result = new HashMap<>();
		if (!(bookingList == null)) {
			result.put("code", 200);
			result.put("result", "성공");
//			result.put("listName", bookingList.getName());
//			result.put("listDate", bookingList.getDate());
//			result.put("listDay", bookingList.getDay());
//			result.put("listHeadcount", bookingList.getHeadcount());
//			result.put("listState", bookingList.getState());
			
			result.put("listResult" ,"이름:" + bookingList.getName()
				+ '\n' + "날짜:" + bookingList.getDate() + '\n'
				+ "일수:" + bookingList.getDay() + '\n' 
				+ "인원:" + bookingList.getHeadcount() + '\n' 
				+ "상태:" + bookingList.getState() + '\n');
		} else {
			
			result.put("code", 500);
			result.put("error_message", "예약 내역이 없습니다");
		}
			return result;
		}
		
		
		
	}



