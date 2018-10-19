package main;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    List<Author> findByName(String Name);
   // <addCours extends Course> addCours save(addCours entity);
	
}
