package com.chainsys.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import com.chainsys.jdbc.test.TestBook;

public class Book {
	public int id;
	public String name;
	public float price;
	public LocalDate publishedDate;
	
	
	public void addBook(TestBook testBook)throws SQLException{
		try{
		String sql="insert into books(id,name,price)values(?,?,?)";
		Connection connection=ConnectionUtil.getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
				
		//BookValidator bookValidator=new BookValidator();
		//TestBook.addBook(testbook.id,testbook.name,testbook.price);
		
		//Book book=new Book();
		//book.id=id;
		//book.name=name;
		//book.price=price;
		
		preparedStatement.setInt(1,testBook.id);
		preparedStatement.setString(2,testBook.name);
		preparedStatement.setFloat(3,testBook.price);
		//converting localDate to SQL date
		
		int rows=preparedStatement.executeUpdate();
		System.out.println("Rows affected:"+rows);
	     ConnectionUtil.closeConnection(connection, preparedStatement, null);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	
	}	
	
}