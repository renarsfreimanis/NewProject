package main;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CoursesRepository extends CrudRepository<Course, Long> {
	
	List<Course> findByName(String name);
}
