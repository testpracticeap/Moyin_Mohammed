package com.BookStore.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//mark class as an Entity 
@Entity
//defining class name as Table name
@Table
public class Books
{

	@Id
	@Column
	private int bookId;
	@Column
	private String bookName;
	
	public int getbookId() {
		return bookId;
		
	}
	
	public String getbookName() {
		return bookName;
		
	}
	
	public void setbookId(int bookId) {
		this.bookId = bookId;		
	}
	
	public void setbookName(String bookName) {
		this.bookName = bookName;
	}
}