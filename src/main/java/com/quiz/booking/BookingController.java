package com.quiz.booking;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	
	
	
	@GetMapping("/check-booking-view")
	public String checkBookingView() {
		
		return "booking/checkBookingView";
	}
	
	@DeleteMapping("/delete-by-id")
	public Map<String, Object> deleteById(
			@RequestParam("id") int id) {
		
	}
}
