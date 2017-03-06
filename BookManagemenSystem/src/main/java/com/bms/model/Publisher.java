package com.bms.model;

import java.util.List;

public class Publisher {

	private Integer publisherId;
	private String publisherName;
	private String address;
	
  private List<Books> booksList;

	public Integer getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(Integer publisherId) {
		this.publisherId = publisherId;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Books> getBooksList() {
		return booksList;
	}

	public void setBooksList(List<Books> booksList) {
		this.booksList = booksList;
	}


	
	
	

}
