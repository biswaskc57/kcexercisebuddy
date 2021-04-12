package ExerciseBuddy.Repo;


	import org.springframework.data.repository.CrudRepository;

import ExerciseBuddy.Domain.User;



	public interface UserRepository extends CrudRepository<User, Long> {
		User findByUsername(String username);
	}

