package com.example.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.book.dto.BookDTO;
import com.example.book.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	public void save(BookDTO bookDTO) {
		System.out.println("BookService.save()입니다.");
		System.out.println(bookDTO);
		bookRepository.save(bookDTO);
	}
	public List<BookDTO> findAll() {
		return bookRepository.findAll();
	}
	public BookDTO finById(Long id) {
		System.out.println("서비스의 findById");
		return bookRepository.findById(id);
	}
	public void delete(Long id) {
		bookRepository.delete(id);
	}
}
