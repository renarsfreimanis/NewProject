package main;

import main.Course;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("coursesRepository")
public interface CoursesRepository extends JpaRepository<Course, Long> {
	//List<Course> findByName(String name);
	
	//Optional<Course> findById(Long id);
	
	Course findByCourseCode(int courseCode);
	
	//Course saveCourse();
}
