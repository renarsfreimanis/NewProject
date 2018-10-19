package main;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Author {
	@Id
	private Long id;
	private String name;
	private String lastname;
	Author(Long id,String name, String lastname){
		setId(id);
		setName(name);
		setLastname(name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		char []ok =new char[name.length()];
		   int counter = 0;
		   for (int i =0; i<name.length();i++){
			  if (Character.isLetter(name.charAt(i))){
				  ok [counter] = name.charAt(i);
				  counter++;
			  }
			 name =String.valueOf(ok);
		  }
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		char []ok =new char[lastname.length()];
		   int counter = 0;
		   for (int i =0; i<lastname.length();i++){
			  if (Character.isLetter(lastname.charAt(i))){
				  ok [counter] = lastname.charAt(i);
				  counter++;
			  }
			 lastname =String.valueOf(ok);
		  }
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		if (id<1) {
			id=this.id+10;
		}
	}

}
