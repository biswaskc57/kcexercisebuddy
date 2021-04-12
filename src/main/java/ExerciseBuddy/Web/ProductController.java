package ExerciseBuddy.Web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;




import ExerciseBuddy.Domain.Product;
import ExerciseBuddy.Domain.Training;
import ExerciseBuddy.Repo.ProductRepo;
import ExerciseBuddy.Services.FileUploadUtil;




@Controller
public class ProductController {
	
	
	
	
	@Autowired
    private ProductRepo repo;
     
	// @RequestParam("photos") MultipartFile multipartFile
    @PostMapping("/save/image")
    public RedirectView saveProduct(Product product
           ) throws IOException {
    	
        System.out.println("JUKKA");
        System.out.println(product);   
        MultipartFile productweb = product.getPhotos();
        System.out.println(productweb.getOriginalFilename());
        
        File file = new File("/TEMP/targetFile.jpg");

        try (OutputStream os = new FileOutputStream(file)) {
            os.write(productweb.getBytes());
        }
        Blob image = null;
        byte[] fileContent = Files.readAllBytes(file.toPath());
        try {
			image = new SerialBlob(fileContent);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        product.setImage(image);
        product.setPhotos(null);
        //String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        //product.setPhotos(fileName);

        Product savedProduct = repo.save(product);
 
        String uploadDir = "product-photos/" + savedProduct.getId();
 
        //FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
         
        return new RedirectView("/productlist", true);
    }
	
    
    
    
    
    @RequestMapping(value =  "/addimage")
    public String addProduct(Model model) {

    	model.addAttribute("product", new Product());
    	
    	return "fileUpload";
    }

	
	
	
}
	
	/*
	@Autowired
	
	private ProductRepo pRepo;
	@Autowired
	private ProductService productService;
	
	@GetMapping("/productlist")
	public String showExampleView(Model model)
	{
		List<Product> products = productService.getAllProduct();
		model.addAttribute("products", products);
		return "/productlist";
	}
    @GetMapping("/showproduct")
    public String showAddProduct()
    {
    	
    	return "addProduct";
    }
    
    
   /* @RequestMapping(value = "/save/image", method = RequestMethod.POST)
	public String save(Product product ) {
    	productService.saveProductToDb(product);
		return "redirect:trainerlist";

	}*/
    
    
    
    
    /*
    @RequestMapping(value="/addP", method = RequestMethod.POST)
    public String saveProduct(@RequestParam("file") MultipartFile file,
    		@RequestParam("pname") String name,
    		@RequestParam("price") int price,
    		@RequestParam("desc") String desc)
    {
    	productService.saveProductToDB(file, name, desc, price);
    	return "redirect:/productlist";
    }
    
    @GetMapping("/deleteProd/{id}")
    public String deleteProduct(@PathVariable("id") Long id)
    {
    	
    	productService.deleteProductById(id);
    	return "redirect:/productlist";
    }
    
    @PostMapping("/changeName")
    public String changePname(@RequestParam("id") Long id,
    		@RequestParam("newPname") String name)
    {
    	productService.chageProductName(id, name);
    	return "redirect:/productlist";
    }
    @PostMapping("/changeDescription")
    public String changeDescription(@RequestParam("id") Long id ,
    		@RequestParam("newDescription") String description)
    {
    	productService.changeProductDescription(id, description);
    	return "redirect:/productlist";
    }
    
    @PostMapping("/changePrice")
    public String changePrice(@RequestParam("id") Long id ,
    		@RequestParam("newPrice") int price)
    {
    	productService.changeProductPrice(id, price);
    	return "redirect:/productlist";
    }*/
