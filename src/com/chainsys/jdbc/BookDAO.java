package com.chainsys.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAO {
	
	
	ResultSet rset=null;
		
	public void addBook(Book b)throws SQLException{
		try{
		String sql="insert into books(id,name,price)values(book_id_seq.NEXTVAL,?,?)";
		Connection connection=ConnectionUtil.getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
				
		BookValidator bookValidator=new BookValidator();
		bookValidator.validateBook(b.name,b.price);
				
		//preparedStatement.setInt(1,id);
		preparedStatement.setString(1,b.name);
		preparedStatement.setFloat(2,b.price);
	//	preparedStatement.setDate(3,Date.valueOf(b.publishedDate));
		int rows=preparedStatement.executeUpdate();
		System.out.println("Rows affected:"+rows);
	     ConnectionUtil.closeConnection(connection, preparedStatement, null);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	
	}	
		
	public void updateBook(int id,String name)throws SQLException{	
		try{
		String sql="update books set name=? where id=?";
		Connection connection=ConnectionUtil.getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setInt(2,id);
		preparedStatement.setString(1,name);
		int rows=preparedStatement.executeUpdate();
		System.out.println("Rows affected:"+rows);
		 ConnectionUtil.closeConnection(connection, preparedStatement, null);
		 }
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
		
	public void deleteBook(int id)throws SQLException{	
		try{
		String sql="delete from books where id=?";
		Connection connection=ConnectionUtil.getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setInt(1,id);
		int rows=preparedStatement.executeUpdate();
		System.out.println("Rows affected:"+rows);
		 ConnectionUtil.closeConnection(connection, preparedStatement, null);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Book> findAll()throws SQLException{
		
		String sql="select id,name,price from books";
		Connection connection=ConnectionUtil.getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		rset=preparedStatement.executeQuery();
		ArrayList<Book> list=new ArrayList<>();
		while(rset.next())
		{
		 Book book=new Book();
		 book.id=rset.getInt("id");
		 book.name=rset.getString("name");
		 book.price=rset.getFloat("price");
		 list.add(book);
		 
		// System.out.println();
		// System.out.println(rset.getInt("id")+rset.getString("name")+rset.getFloat("price"));
		// ConnectionUtil.closeConnection(connection, preparedStatement, null);
		}
		ConnectionUtil.closeConnection(connection, preparedStatement, null);
		return list;
	
		
	}	
	public Book findById(Book book)throws SQLException{
		
			String sql="select id,name,price from books where id=?";
			Connection connection=ConnectionUtil.getConnection();
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1,book.id);
			rset=preparedStatement.executeQuery();
			Book b=null;
			if(rset.next())
			{
			 b=new Book();
			 b.id=rset.getInt("id");
			 b.name=rset.getString("name");
			 b.price=rset.getFloat("price");
			// b.publishedDate=rset.getDate("published_date").toLocalDate();
			 ConnectionUtil.closeConnection(connection, preparedStatement, null);
			// System.out.println();
		   // System.out.println(rset.getInt("id")+rset.getString("name")+rset.getFloat("price"));				
			}
			return b;	
					
	}
}

	


