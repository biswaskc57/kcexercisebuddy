package ExerciseBuddy.Repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ExerciseBuddy.Domain.Training;
public interface TrainingRepository 	 extends CrudRepository<Training, Long> {

		List<Training>findById(int id);
	}

