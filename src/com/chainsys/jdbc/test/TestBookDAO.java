package com.chainsys.jdbc.test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import com.chainsys.jdbc.Book;
import com.chainsys.jdbc.BookDAO;
import com.chainsys.jdbc.BookValidator;

public class TestBookDAO {

	public static void main(String[] args)throws SQLException {
		Scanner scanner=new Scanner(System.in);
	
		 System.out.println("Enter id,name,price,date(yyyy-mm-dd)");
		// System.out.println("Enter a date");
		// String inputDate=scanner.next();
		 //LocalDate date=LocalDate.parse(inputDate);//converts string to LocalDate
		 //System.out.println(date);
		 
		 Book book = new Book();
		 
		 book.id=scanner.nextInt();
		 book.name=scanner.next();
		 book.price=scanner.nextFloat();	
		 String pd=scanner.next();
		 book.publishedDate=LocalDate.parse(pd);
		 
		 
		 BookDAO bookDAO=new BookDAO();
		 BookValidator validator=new BookValidator();
		 try{
			 validator.validateAdd(book);
		 bookDAO.addBook(book);
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }
	//	 bookDAO.addBook(book);						
	//	 bookDAO.findAll();
	
        Book bookResult=bookDAO.findById(book);
        if(bookResult!=null){
        	System.out.println(bookResult.id);
        	System.out.println(bookResult.name);
        	System.out.println(bookResult.price);
        	System.out.println(bookResult.publishedDate);
        }
        else{
        	System.out.println("");
        }
        ArrayList<Book> bookList=bookDAO.findAll();
        if(bookList.isEmpty()){
        	System.out.println("No records found");
        }
        else{
        	for(Book b:bookList){
        		System.out.println(b.id);
        		System.out.println(b.name);
        		System.out.println(b.price);
        	}
        }
        scanner.close();
}
}

