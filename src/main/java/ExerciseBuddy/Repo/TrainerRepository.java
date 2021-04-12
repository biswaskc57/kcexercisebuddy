package ExerciseBuddy.Repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ExerciseBuddy.Domain.Trainer;
public interface TrainerRepository 	 extends CrudRepository<Trainer, Long> {

		List<Trainer>findByName(String name);
	}


