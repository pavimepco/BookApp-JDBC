package com.chainsys.jdbc;

public class BookValidator {
	public void validateBook(String name,float price)throws Exception{
		if(name==null)
		{
			throw new Exception("Enter a valid name");
		}
		if(price<=0)
		{
			throw new Exception("Enter a valid price");
		}
	}
	
	public void validateAdd(Book book)throws Exception{
		
		if(book.name==null)
		{
			throw new Exception("Enter a valid name");
		}
		if(book.price<=0)
		{
			throw new Exception("Enter a valid price");
		}
	}


	
	
	public void validateUpdate(Book book)throws Exception{
		if(book.id<=0){
			throw new Exception("Invalid");
		}
		if(book.name==null)
		{
			throw new Exception("Enter a valid name");
		}
		if(book.price<=0)
		{
			throw new Exception("Enter a valid price");
		}
	}

}
