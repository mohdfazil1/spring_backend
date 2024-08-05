package com.example.ecom.Service;
import com.example.ecom.Model.Product;
import com.example.ecom.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getallproduct(){
        return productRepository.findAll();
    }

    public void addproduct(Product product){
        productRepository.save(product);
    }

    public void updatebyid(Product product) {
        productRepository.save(product);
    }

    public Product getProductById(int id) {

       return productRepository.findById(id).orElse(new Product());
    }

    public void Deleteproduct(int id) {
        productRepository.deleteById(id);
    }

    public List<Product> SearchbyProduct(String keyword) {
        return productRepository.searchproduct(keyword);

    }
}
