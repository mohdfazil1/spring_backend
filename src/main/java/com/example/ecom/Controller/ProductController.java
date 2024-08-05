package com.example.ecom.Controller;
import com.example.ecom.Model.Product;
import com.example.ecom.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService service;


    @GetMapping("/products")
    public ResponseEntity <List<Product>> GetallProduct(){
        List<Product> getproducts=service.getallproduct();
        return new ResponseEntity<>(getproducts,HttpStatus.OK);
    }


    @PostMapping("/addproducts")
    public ResponseEntity <String> Addproduct(@RequestBody Product product){
        try{
            service.addproduct(product);
            return new ResponseEntity<>("Product Added Successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Internal Server Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<?> productbyid(@PathVariable int id){
        try {
            Product product = service.getProductById(id);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("ID NOT VALID", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/updateproducts")
    public ResponseEntity<?> updateproduct(@RequestBody Product product){
        try {
             service.updatebyid(product);
            return new ResponseEntity<>("Product Updated Successfully",HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<>("Product Not Updated",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteproducts/{id}")
    public ResponseEntity<?> deleteproduct(@PathVariable int id){
        try {
            service.Deleteproduct(id);
            return  new ResponseEntity<>("Product Deleted Successfully",HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<>("ID NOT VALID",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/searchproducts")
    public ResponseEntity<List<Product>> searchbyproduct(@RequestParam String keyword){
        List<Product> product=service.SearchbyProduct(keyword);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }
}

