package main;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
@Entity
public class Course {
	@Id
	 private Long id;
	 private String name;
	 private String author;
	 private int coursecode;
	 private int creditpoints;
	 Course(Long id, String name, String author, int coursecode, int creditpoints){
		     setId(id);
			 setName(name);
			 setAuthor(author);
			 setCoursecode(coursecode);
			 setCreditpoints(creditpoints);


	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		if (id<1) {
			id=this.id+10;
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		char []ok =new char[name.length()];
		   int counter = 0;
		   for (int i =0; i<name.length()-4;i++){
			  if (Character.isLetter(name.charAt(i))){
				  ok [counter] = name.charAt(i);
				  counter++;
			  }
			 name =String.valueOf(ok);
		  }
		
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		char []ok =new char[author.length()];
		   int counter = 0;
		   for (int i =0; i<author.length();i++){
			  if (Character.isLetter(author.charAt(i))){
				  ok [counter] = author.charAt(i);
				  counter++;
			  }
			 author =String.valueOf(ok);
		  }
	}
	public int getCoursecode() {
		return coursecode;
	}
	public void setCoursecode(int coursecode) {
		if (coursecode<0) {
			coursecode=0;
		}
	}
	public int getCreditpoints() {
		return creditpoints;
	}
	public void setCreditpoints(int creditpoints) {
		if (creditpoints<0) {
			creditpoints=0;
		}
		
	}
	}