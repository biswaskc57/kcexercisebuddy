package ExerciseBuddy;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



import ExerciseBuddy.Domain.Category;
import ExerciseBuddy.Domain.Trainer;
import ExerciseBuddy.Domain.User;
import ExerciseBuddy.Repo.CategoryRepository;
import ExerciseBuddy.Repo.TrainerRepository;
import ExerciseBuddy.Repo.UserRepository;






@SpringBootApplication
public class ExerciseAppApplication {

	private static final Logger log = LoggerFactory.getLogger(ExerciseAppApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ExerciseAppApplication.class, args);
		
	}
		@Bean
		public CommandLineRunner demo( CategoryRepository cRepository, TrainerRepository trRepository,UserRepository uRepository ) {
			return (args) ->{
				
				
				
				
				cRepository.save(new Category("Abs"));
				cRepository.save(new Category("Chest"));
				cRepository.save(new Category("Shoulder"));
				cRepository.save(new Category("Legs"));
				cRepository.save(new Category("Back"));
				
				
				
				
				uRepository.deleteAll();
				//Create users: admin/ admin user/user
				User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
				User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
				uRepository.save(user1);
				uRepository.save(user2);	
	
		
		
		Trainer trainer1 = new Trainer("Biswas KC", "Biswas43gmail.com", 451898090, "122222-323", "Body-building",
				"Trainer for 2 years");
		Trainer trainer2 = new Trainer("Danny shepherd", "Danny3gmail.com", 451898092, "652222-3623", "Jumba",
				"Trainer for 2 years");
		Trainer trainer3 = new Trainer("lung chong", "lung3gmail.com", 225189809, "4222-3239", "Karate",
				"Trainer for 2 years");
		
		trRepository.save(trainer1);
		trRepository.save(trainer2);
		trRepository.save(trainer3);
		
		log.info("fetch all exercises");
		
		for (Trainer trainer : trRepository.findAll()) {
			log.info(trainer.toString());
		}
		};
}
		
		
}

