package com.example.book.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.book.dto.BookDTO;

@Repository
public class BookRepository {
	@Autowired
	private SqlSessionTemplate sql;

	public void save(BookDTO bookDTO) {
		System.out.println("BookRepository.save()입니다.");
		sql.insert("Book.save", bookDTO);
	}

	public List<BookDTO> findAll() {
		System.out.println("레파지의 findAll");
		return sql.selectList("Book.findAll");
	}

	public BookDTO findById(Long id) {
		System.out.println("레파지의 findById");
		return sql.selectOne("Book.findById", id);
	}
	
}
