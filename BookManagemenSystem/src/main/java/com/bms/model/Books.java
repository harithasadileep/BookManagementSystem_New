package com.bms.model;

import java.util.ArrayList;
import java.util.List;

public class Books {

	private Integer bookId;
	private String author;
	private String title;
	private String available;
	private String price;
	
	private List<BarrowDetails> barrowDetailsEntity = new ArrayList<BarrowDetails>();


	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public List<BarrowDetails> getBarrowDetailsEntity() {
		return barrowDetailsEntity;
	}

	public void setBarrowDetailsEntity(List<BarrowDetails> barrowDetailsEntity) {
		this.barrowDetailsEntity = barrowDetailsEntity;
	}

	

}
