package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import domain.Book;

public class Cart {
	
	HashMap<String,Book> hm=new HashMap<String,Book>();
	
	public void addBook(String id){
		if (hm.containsKey(id)){
			Book book=hm.get(id);
			int temp=book.getShoppingNum();
			book.setShoppingNum(temp+1);
		}
		else{
			hm.put(id,new BookService().getBookById(id));
		}
		
	}
	
	public void delBook(String id){
		hm.remove(id);
	}
	
	public void clearAll(){
		hm.clear();
	}
	
	public ArrayList showCart(){
		ArrayList<Book> al=new ArrayList<Book>();
		Iterator iterator=hm.keySet().iterator();
		while (iterator.hasNext()){
			String id=(String)iterator.next();
			Book book=hm.get(id);
			al.add(book);
		}
		return al;	
	}

	public float getTotalPrice(){
		float totalPrice = 0;
		ArrayList<Book> al=new ArrayList<Book>();
		Iterator iterator=hm.keySet().iterator();
		while(iterator.hasNext()){
			String id=(String) iterator.next();
			Book book=hm.get(id);
			totalPrice+=book.getShoppingNum()*book.getPrice();
		}
		return totalPrice;
	}
}
