package fr.bsnt.controller;

import fr.bsnt.model.Products;
import fr.bsnt.model.Users;
import fr.bsnt.repository.ProductRepository;
import fr.bsnt.service.ProductService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping(value = "/{id}")
    public List<Products> getProducts(Long id){
        return productService.getAllProducts();
    }
    @PostMapping("/insert")
    public Products productSave(@RequestBody Products products){
        return productService.createProduct(products);
    }

    @PutMapping("/update/{id}")
    public Products updateUser(@PathVariable Long id, @RequestBody Products products) {
        return productService.updateProduct(id, products);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
    }

}
