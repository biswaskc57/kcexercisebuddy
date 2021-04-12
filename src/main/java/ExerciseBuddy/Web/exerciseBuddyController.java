package ExerciseBuddy.Web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ExerciseBuddy.Domain.Category;
import ExerciseBuddy.Domain.Product;
import ExerciseBuddy.Domain.Trainer;
import ExerciseBuddy.Domain.Training;
import ExerciseBuddy.Repo.CategoryRepository;
import ExerciseBuddy.Repo.ProductRepo;
import ExerciseBuddy.Repo.TrainerRepository;
import ExerciseBuddy.Repo.TrainingRepository;

@Controller
class exerciseBuddyController {

	@Autowired
	private CategoryRepository cRepository;

	@Autowired
	private TrainerRepository trRepository;

	@Autowired
	private TrainingRepository trainingRepository;
	
	@Autowired
	private ProductRepo productRepository;
	
	
	
	/*@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login (){
		return "login";
	}*/
	
	

	// Rest API to find list of trainers
	@RequestMapping(value = { "/trainers" }, method = RequestMethod.GET)
	public @ResponseBody List<Trainer> findTrainerList() {
		return (List<Trainer>) trRepository.findAll();
	}

	// Rest API to find list of trainers by their id
	@RequestMapping(value = { "/trainer/id" }, method = RequestMethod.GET)
	public @ResponseBody Optional<Trainer> findTrainerByIdRest(@PathVariable("id") Long Id) {
		return trRepository.findById(Id);
	}

	
	
	// Rest API to find list of training
	@RequestMapping(value = { "/trainings" }, method = RequestMethod.GET)
	public @ResponseBody List<Training> findTrainingList() {
		return (List<Training>) trainingRepository.findAll();
	}

	// Rest API to find list of training by their id
	@RequestMapping(value = { "/training/id" }, method = RequestMethod.GET)
	public @ResponseBody Optional<Training> findTrainingByIdRest(@PathVariable("id") Long Id) {
		return trainingRepository.findById(Id);
	}

	
	
	
	// Rest API to find list of Category
	@RequestMapping(value = { "/categories" }, method = RequestMethod.GET)
	public @ResponseBody List<Category> findCategoryList() {
		return (List<Category>) cRepository.findAll();
	}

	
	// Rest API to find list of category by their id
	@RequestMapping(value = { "/category/id" }, method = RequestMethod.GET)
	public @ResponseBody Optional<Category> findCategoryByIdRest(@PathVariable("id") Long Id) {
		return cRepository.findById(Id);
	}

	
	
	
	
	/**
	 * After logging in: this is the homepage
	 * @param trainer
	 * @param model
	 * @return the list of all the trainers
	 */
	@RequestMapping(value = { "/", "/trainerlist" }, method = RequestMethod.GET)
	public String trainerList(@ModelAttribute Trainer trainer, Model model) {
		model.addAttribute("trainers", trRepository.findAll());
		return "trainerlist";
	}

	
	
	/**
	 * Trainer booking form-page
	 * @param model
	 * @return 
	 */
	@RequestMapping(value = "/booktrainer", method = RequestMethod.GET)
	public String bbookTutor(Model model) {
		model.addAttribute("trainings", new Training());
		model.addAttribute("categories", cRepository.findAll());
		model.addAttribute("trainers", trRepository.findAll());
		return "bookTrainer";

	}

	
	
	/**
	 * Saves the trainer and returns to trainerlist when clicked submit
	 * @param training
	 * @return
	 */
	
	// Saving a exercise
	// @RequestMapping(value = "/save", method = RequestMethod.POST)
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Training training) {
		trainingRepository.save(training);
		return "redirect:trainerlist";

	}

	
	/**
	 * Shows the schedule of selected trainer in html list
	 * @param trainerId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/schedule/{id}")
	public String schedule(@PathVariable("id") Long trainerId, Model model) {
		model.addAttribute("trainers", trRepository.findById(trainerId).get());
		return "schedulelist";
	}
	
	
	/*@RequestMapping(value = "/fileupload/{id}")
	public String fileUpload(@PathVariable("id") Long trainerId, Model model) {
		model.addAttribute("trainers", trRepository.findById(trainerId).get());
		return "fileupload";
	}*/
	
	@RequestMapping(value = "/fileupload", method = RequestMethod.GET)
	public String save(Product product) {
		productRepository.save(product);
		return "fileupload";

	}


}
