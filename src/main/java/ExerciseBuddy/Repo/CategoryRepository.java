package ExerciseBuddy.Repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ExerciseBuddy.Domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{
 
	List<Category> findByName(String name);
}
