package com.example.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.book.dto.BookDTO;
import com.example.book.service.BookService;



@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	
	// 책 등록화면 출력
	@GetMapping("/save")
	public String save() {
		System.out.println("BookController.save(), get");
		return "save";
	}
	
	// 책 등록 처리
	@PostMapping("/save")
	public String save(@ModelAttribute BookDTO bookDTO) {
		System.out.println("BookController.save(), post");
		System.out.println("BookDTO = " + bookDTO);
		bookService.save(bookDTO);
//		return "index";
//		return "list";  --> 단순하게 list.html만 요청(데이터가 담기지 않고 list페이지로 감.)
		// list 출력을 위해 list 주소 요청
		// redirect: 컨트롤러의 메서드에서 다른 메서드의 주소를 요청하고자 할 때(재요청)
		return "redirect:/list";
	}
	
	// 책 목록 출력
	@GetMapping("/list")
	public String findAll(Model model) {
		System.out.println("BookController.list()");
		//DB에서 리스트(목록)데이터를 가져온다.
		List<BookDTO> bookDTOs = bookService.findAll();
		// 리스트 데이터를 model에 담는다.
		model.addAttribute("bookList", bookDTOs);
		return "list";
	}
	
	@GetMapping("/book/{id}")
	public String findById(@PathVariable("id") Long id, Model model){
		System.out.println("id = " + id);
		BookDTO bookDTO = bookService.finById(id);
		model.addAttribute("book", bookDTO);
		return "detail";
	}
	
	@GetMapping("/book/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		System.out.println("북컨트롤러의 delete 메소드");
		bookService.delete(id);
		return "redirect:/list";
	}
	
	@GetMapping("/book/update/{id}")
	public String update(@PathVariable("id") Long id, Model model) {
		BookDTO bookDTO = bookService.finById(id);
		model.addAttribute("book", bookDTO);
		return "update";
	}
	
	@PostMapping("/update")
	public String update(BookDTO bookDTO) {
		System.out.println("BookDTO = " + bookDTO);
		bookService.update(bookDTO);
		return "redirect:/list"; 
	}
}
