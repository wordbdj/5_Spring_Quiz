package com.quiz.lesson06;

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
		
	
		return "lesson06/addBookmark";
	}
	
	// AJAX가 하는 요청
	// 즐겨찾기 추가 로직
	
	@ResponseBody
	@PostMapping("/add-bookmark")
	public Map<String, Object> addBookmark(
			@RequestParam("name") String name,
			@RequestParam("url") String url ){
		
		// DB insert
		bookmarkBO.addBookmark(name, url);
		
		// 성공 JSON
		// {"code":200, "result":"성공"}
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		return result;
	}
	
	// AJAX가 하는 요청 - url 중복확인
	@ResponseBody
	@GetMapping("/is-duplication-url")
	public Map<String, Object> isDuplicationUrl(
			@RequestParam("url")String url) {
		
		// DB select
		boolean isDuplication = bookmarkBO.isDuplicationByUrl(url);
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("isDuplication", isDuplication);
		
		return result;
	}
	
	// AJAX 가 하는 요청 - delete by id
	@ResponseBody
	@DeleteMapping("/delete-by-id")
	public Map<String, Object> deleteById(
			@RequestParam("id") int id) {
		
		
		// DB delete
		int rowCount = bookmarkBO.deleteById(id);
		
		Map<String, Object> result = new HashMap<>();
		if (rowCount > 0) {
		result.put("code", 200);
		result.put("result","성공" );
		} else {
			result.put("code", 500);
			result.put("error_message", "삭제할 항목이 존재하지 않습니다.");
		}
		
		
		// 응답값 JSON
		return result;
		
		
	}
	
	
	// http://localhost:8080/lesson06/after-add-bookmark-view
	@GetMapping("/after-add-bookmark-view")
	public String afterAddBookmarkView(Model model) {
		
		
		// DB Select
		List<Bookmark> bookmarkList = bookmarkBO.getBookmark();
		
		
		// Model 
		model.addAttribute("bookmarkList", bookmarkList);
		
		
		return "lesson06/afterAddBookmark";
	}
	
}
