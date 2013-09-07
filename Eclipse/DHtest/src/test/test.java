package test;

public class test {
	
	public static void main (String[] args){
		Book[] books=new Book[20];
		for (int i=0;i<20;i++){			
			books[i]=new Book("金瓶梅"+i);
		}
		Student s=new Student("张三",books);
		for (int i=0;i<books.length;i++){
			s.read(i);
		}
	}
	
	

}

class Book{
	String name;
	public Book(String name){
		super();
		this.name=name;
		
	}
}

class Student{
	String name;
	Book[] books;
	public Student(String name,Book[] books){
		super();
		this.name=name;	
		this.books=books;
	}
	
	public void read(int i){
		System.out.println(this.name+"正在读"+books[i].name);
	}
}