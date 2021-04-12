package ExerciseBuddy.Domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {
	@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long categoryId;
		private String name;
	
		@JsonIgnore
		@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
		private List<Training> training;
		
		public Category() {
			
		}

		public Category(String name) {
			super();   
			this.name = name;
			
		}

		public Long getCategoryId() {
			return categoryId;
		}

		public void setCategoryId(Long categoryId) {
			this.categoryId = categoryId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Training> getTraining() {
			return training;
		}

		public void setExercises(List<Training> training) {
			this.training = training;
		}
		
		

}
