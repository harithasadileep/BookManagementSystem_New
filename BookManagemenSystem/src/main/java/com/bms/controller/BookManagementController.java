package com.bms.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bms.Entities.BarrowDetailsEntity;
import com.bms.Entities.BooksEntity;
import com.bms.Entities.MemberEntity;
import com.bms.Entities.PublisherEntity;
import com.bms.dao.BarrowDetailsDAO;
import com.bms.dao.BookDAO;
import com.bms.dao.MemberDAO;
import com.bms.dao.PublisherDAO;
import com.bms.mapper.CustomBeanConverter;
import com.bms.mapper.DozerHelper;
import com.bms.model.BarrowDetails;
import com.bms.model.Books;
import com.bms.model.Member;
import com.bms.model.Publisher;

@RestController
// @RequestMapping("/BookManager")
public class BookManagementController {

	@Autowired
	private BookDAO bookDAO;
	@Autowired
	private MemberDAO memberDAO;

	@Autowired
	private PublisherDAO publisherDAO;
	
	@Autowired
	private BarrowDetailsDAO barrowDetailsDAO;
	
	
	
	@Autowired
	private EntityManager em;

	@Autowired
	private CustomBeanConverter customBeanConverter;

	@RequestMapping(value = "/postBook", method = RequestMethod.POST)
	public String postBook(@RequestBody Books book) {

		BooksEntity booksEntity = null;
		booksEntity = customBeanConverter.map(book, BooksEntity.class);
		bookDAO.save(booksEntity);
		return "Success";
	}

	@RequestMapping(value = "/getBooks", method = RequestMethod.GET)
	public List<BooksEntity> getbookList() {
		return (List<BooksEntity>) bookDAO.findAll();

	}

	@RequestMapping(value = "/getBooks/{bookId}", method = RequestMethod.GET)
	public BooksEntity getBookById(@PathVariable("bookId") int bookId) {
		return bookDAO.findOne(bookId);

	}

	@RequestMapping(value = "/deleteBook/{bookId}", method = RequestMethod.DELETE)
	public String deleteBook(@PathVariable("bookId") int bookId) {
		bookDAO.delete(bookId);
		return "BookId " + bookId + " Deleted";

	}

	@RequestMapping(value = "/putBook", method = RequestMethod.PUT)
	public String putBook(@RequestBody Books book) {
		BooksEntity booksEntity = null;
		booksEntity = customBeanConverter.map(book, BooksEntity.class);
		bookDAO.save(booksEntity);
		return "updated successfully";

	}

	@RequestMapping(value = "/postMember", method = RequestMethod.POST)
	public String postMember(@RequestBody Member member) {

		MemberEntity memberEntity = customBeanConverter.map(member, MemberEntity.class);
		memberDAO.save(memberEntity);
		return "Success";

	}

	@RequestMapping(value = "/getMembers", method = RequestMethod.GET)
	public List<MemberEntity> getMemberList() {
		return memberDAO.findAll();

	}

	@RequestMapping(value = "/getMember/{memberId}", method = RequestMethod.GET)
	public MemberEntity getMemberById(@PathVariable("memberId") int memberId) {
		return memberDAO.findOne(memberId);

	}

	@RequestMapping(value = "/deleteMember/{memberId}", method = RequestMethod.DELETE)
	public String deleteMember(@PathVariable("memberId") int memberId) {
		memberDAO.delete(memberId);
		return "MemberId " + memberId + " Deleted";

	}

	@RequestMapping(value = "/putMember", method = RequestMethod.PUT)
	public String putMember(@RequestBody Member member) {
		MemberEntity memberEntity = customBeanConverter.map(member, MemberEntity.class);
		memberDAO.saveAndFlush(memberEntity);
		return "updated successfully";

	}

	@RequestMapping(value = "/postPublisher", method = RequestMethod.POST)
	public String postPublisher(@RequestBody Publisher publisher) {

		PublisherEntity publisherEntity = customBeanConverter.map(publisher, PublisherEntity.class);
		publisherDAO.save(publisherEntity);
		return "Success";

	}

	@RequestMapping(value = "/getPublishers", method = RequestMethod.GET)
	public List<PublisherEntity> getPublisherList() {
		return publisherDAO.findAll();

	}

	@RequestMapping(value = "/getPublisher/{publisherId}", method = RequestMethod.GET)
	public PublisherEntity getPublisherById(@PathVariable("publisherId") int publisherId) {
		return publisherDAO.findOne(publisherId);

	}

	@RequestMapping(value = "/deletePublisher/{publisherId}", method = RequestMethod.DELETE)
	public String deletePublisher(@PathVariable("publisherId") int publisherId) {
		publisherDAO.delete(publisherId);
		return "publisherId " + publisherId + " Deleted";

	}

	@RequestMapping(value = "/putPublisher", method = RequestMethod.PUT)
	public String putPublisher(@RequestBody Publisher publisher) {
		PublisherEntity mublisherEntity = customBeanConverter.map(publisher, PublisherEntity.class);
		publisherDAO.saveAndFlush(mublisherEntity);
		return "updated successfully";

	}
	
	
	@RequestMapping(value = "/postBarrowDetails", method = RequestMethod.POST)
	public String postBarrowDetails(@RequestBody BarrowDetails barrowDetails) {
		BarrowDetailsEntity barrowDetailsEntity = customBeanConverter.map(barrowDetails, BarrowDetailsEntity.class);
		barrowDetailsDAO.save(barrowDetailsEntity);
		return "Success";
	}
	
	@RequestMapping(value = "/getBarrowDetails", method = RequestMethod.GET)
	public List<BarrowDetails> getBarrowDetails() {
		List<BarrowDetailsEntity> barrowDetailsEntityList = barrowDetailsDAO.findAll();
		List<BarrowDetails>  barrowDetailsList = DozerHelper.map(customBeanConverter, barrowDetailsEntityList, BarrowDetails.class);
		return barrowDetailsList;
	}
	
	@RequestMapping(value = "/getBarrowDetails/{barrowId}", method = RequestMethod.GET)
	public BarrowDetails getBarrowDetailsByid(@PathVariable("barrowId") int barrowId) {
		BarrowDetailsEntity entity =  	barrowDetailsDAO.findOne(barrowId);
		BarrowDetails barrowDetails = customBeanConverter.map(entity, BarrowDetails.class);
		return barrowDetails;
	}

}
