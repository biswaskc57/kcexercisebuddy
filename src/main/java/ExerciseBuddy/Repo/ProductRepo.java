package ExerciseBuddy.Repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ExerciseBuddy.Domain.Product;

public interface ProductRepo  extends CrudRepository<Product, Long> {

	List<Product>findById(int id);
}



