package main;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import main.Course;
import main.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CourseController {
	//@Autowired
	private CoursesRepository coursesRepository;
    private AuthorRepository authorRepository;
	@PostMapping
	public void createCourse(@RequestBody Course addcourse) {
		if(addcourse.equals(null) ) {
		addcourse = new Course((long) 10,"Vesture","Emils",113,4);
		/*Course course1 = new Course(
				course1.getId(),
				course1.getAuthor(),
				course1.getName(),
				course1.getCoursecode(),
				course1.getCreditpoints());*/
			
			coursesRepository.save(addcourse);
			
		}
	}
	

	@RequestMapping("/Showauthors")
	public String Showauthors(Model model){
		//List<Course> myList = new ArrayList<>();
		List<String> Author = new ArrayList<>();
		List<Author> myList = (List<Author>) authorRepository.findAll();
		for (int i =0;i<myList.size();i++) {
           if(!Author.contains(myList.get(i).getName())) {
        	   Author.add(myList.get(i).getName());
           }
		}
		model.addAttribute("autori", Author);
		return "form";
	}
}
		
			
/*
	@PostMapping("/addCourse")
		public Course addCourse(String name, String author,int coursecode,int creditpoint) {	
		   // Course test = new Course("Vesture","Emils",113,4);
		    Course add = new Course(name,author,coursecode,creditpoint);
		    return add;
		    
	}
	*/


