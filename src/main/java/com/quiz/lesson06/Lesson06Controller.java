package com.quiz.lesson06;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookmarkBO;
import com.quiz.lesson06.domain.Bookmark;

@RequestMapping("/lesson06")
@Controller
public class Lesson06Controller {

	@Autowired
	public BookmarkBO bookmarkBO;
	
	// http://localhost:8080/lesson06/add-bookmark-view
	@GetMapping("/add-bookmark-view")
	public String addBookmarkView() {
		
	String in ="as";
	in.
		
		return "lesson06/addBookmark";
	}
	
	
	@ResponseBody
	@PostMapping("/add-bookmark")
	public String addBookmark(
			@RequestParam("title") String title,
			@RequestParam("address") String address ){
		
		// DB insert
		bookmarkBO.addBookmark(title, address);
		
		return "success";
	}
	
	@GetMapping("/after-add-bookmark-view")
	public String afterAddBookmarkView(Model model) {
		
		
		// DB Select
		List<Bookmark> bookmarkList = bookmarkBO.getBookmark();
		
		
		// Model 
		model.addAttribute("bookmarkList", bookmarkList);
		
		
		return "lesson06/afterAddBookmark";
	}
	
}
