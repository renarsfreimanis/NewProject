package main;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import main.Course;
//import main.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CourseController {
	
	@Autowired
	private CoursesRepository coursesRepo;
	
	@RequestMapping(value="/course", method = RequestMethod.GET)
    public ModelAndView course(){
        ModelAndView modelAndView = new ModelAndView();
        Course course = new Course();
        modelAndView.addObject("course", course);
        modelAndView.setViewName("course");
        return modelAndView;
    }
	

    @RequestMapping(value = "/course", method = RequestMethod.POST)
    public ModelAndView createNewCourse(@Valid Course course, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        Course courseExists = coursesRepo.findByCourseCode(course.getCourseCode());
        if (courseExists != null) {
            bindingResult
                    .rejectValue("course_code", "error.course",
                            "There is already a course registered with the course code provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("course");
        } else {
            coursesRepo.save(course);
            modelAndView.addObject("successMessage", "Course has been registered successfully");
            modelAndView.addObject("course", new Course());
            modelAndView.setViewName("course");

        }
        return modelAndView;
    }
    
    /*@GetMapping(path="/allCourses")
   	public @ResponseBody Iterable<User> getAllUsers() {
   		return coursesRepo.findAll();
   	}*/
}

