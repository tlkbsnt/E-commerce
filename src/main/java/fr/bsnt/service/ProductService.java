package fr.bsnt.service;

import fr.bsnt.model.Products;
import fr.bsnt.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Products> getAllProducts(){
        return productRepository.findAll();
    }
    public Products getById(Long id){
        return productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product Not found"+id));
    }
    public Products createProduct(Products product){
        return productRepository.save(product);
    }
    /*
        product_company_name
        product_name
        product_price
     */
    public Products updateProduct(Long id, Products products){
        Products existingProduct = productRepository.findById(id).orElseThrow(() ->new EntityNotFoundException("Product not found"+id));
        existingProduct.setId(products.getId());
        existingProduct.setProduct_company_name(products.getProduct_company_name());
        existingProduct.setProduct_name(products.getProduct_name());
        existingProduct.setProduct_price(products.getProduct_price());

        return existingProduct;
    }
    public void deleteProductById(Long id){
        productRepository.deleteById(id);
    }


}
