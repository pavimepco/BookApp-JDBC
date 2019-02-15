/**
 * 
 */
package com.chainsys.jdbc;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author pavi2107
 *
 */
public class BookDAOTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Ignore
	public void testAddBook() throws Exception{
		BookDAO bookDAO=new BookDAO();
		/*Book book=new Book();
		book.id=1;
		book.name="Python";
		book.price=200;
		book.publishedDate=LocalDate.parse("2019-09-09");
		bookDAO.addBook(book);*/
		
		Book book1=new Book();
		book1.id=6;
		Book b=bookDAO.findById(book1);
		System.out.println(b.name);
		assertEquals("Python",b.name);
		}
	
	
	@Ignore
	public void testUpdateBook() throws Exception{
		BookDAO bookDAO=new BookDAO();
		Book book=new Book();
		book.id=6;
		book.name="Php";
		bookDAO.updateBook(	book.id,book.name);
		
		
		Book b=bookDAO.findById(book);
		//System.out.println(b.name);
		assertEquals(book.name,b.name);
		
	}
	
	
	@Ignore
	public void testDeleteBook() throws Exception{
		BookDAO bookDAO=new BookDAO();
		Book book=new Book();
		book.id=4;
		//book.name="Go";
		//book.price=100;
		bookDAO.deleteBook(	book.id);
		
		
		Book b=bookDAO.findById(book);
		//System.out.println(b.name);
		assertEquals(null,b.id);
		
	}
	@Test
	public void testFindAll() throws Exception{
		BookDAO bookDAO=new BookDAO();
		Book book=new Book();
		book.id=3;
		book.name="Go";
		book.price=150;
		ArrayList<Book> list=new ArrayList<>();
		list.add(book);
		if(size(list)==list1){
			System.out.println("Valid");
		}
		
	}
	
	@Ignore
	public void testFindById() throws Exception{
		BookDAO bookDAO=new BookDAO();
		Book book1=new Book();
		book1.id=6;
		Book b=bookDAO.findById(book1);
		assertEquals(book1.id,b.id);
		
	}
	
	
	public void test() throws SQLException {
		
	}

}
