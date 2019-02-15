package com.chainsys.jdbc.test;

import java.sql.SQLException;

import java.util.Scanner;

import com.chainsys.jdbc.Book;


public class TestBook {

	public int id;
	public String name;
	public float price;

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter id,name,price");
		TestBook testBook = new TestBook(); 
		testBook.id=scanner.nextInt();
		 testBook.name=scanner.next();
		 testBook.price=scanner.nextFloat();		
		 Book book=new Book();
		 book.addBook(testBook);						
		
	}

}
