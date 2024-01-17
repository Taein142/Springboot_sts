package com.example.book.dto;

import lombok.*;

@Getter
@Setter
@ToString
public class BookDTO {
	private long id;
	private String bookName;
	private String bookAuthor;
	private String bookPublisher;
	private int bookPrice;
}
