package ExerciseBuddy.Domain;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(columnDefinition = "MEDIUMBLOB")
	@Lob
	private MultipartFile photos;

	private Blob image;
	
	private String name;
	private String description;
	private boolean isAvailable;
	private int price;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "trainer_id")
	private Trainer trainer;

	public Product() {

	}
	
	






	public Product(MultipartFile photos, Blob image, String name, String description, boolean isAvailable, int price,
			Trainer trainer) {
		super();
		this.photos = photos;
		this.image = image;
		this.name = name;
		this.description = description;
		this.isAvailable = isAvailable;
		this.price = price;
		this.trainer = trainer;
	}






	public Long getId() {
		return id;
	}








	public void setId(Long id) {
		this.id = id;
	}








	public MultipartFile getPhotos() {
		return photos;
	}








	public void setPhotos(MultipartFile photos) {
		this.photos = photos;
	}








	public Blob getImage() {
		return image;
	}








	public void setImage(Blob image) {
		this.image = image;
	}








	public String getName() {
		return name;
	}








	public void setName(String name) {
		this.name = name;
	}








	public String getDescription() {
		return description;
	}








	public void setDescription(String description) {
		this.description = description;
	}








	public boolean isAvailable() {
		return isAvailable;
	}








	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}








	public int getPrice() {
		return price;
	}








	public void setPrice(int price) {
		this.price = price;
	}








	public Trainer getTrainer() {
		return trainer;
	}








	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}








	@Transient
	public String getPhotosImagePath() {
		if (photos == null || id == null)
			return null;

		return "/user-photos/" + id + "/" + photos;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", photos=" + photos + ", name=" + name + ", Description=" + description
				+ ", isAvailable=" + isAvailable + ", price=" + price + ", trainer=" + trainer + "]";
	}
	
	
	
}
