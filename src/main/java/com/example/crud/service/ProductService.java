package com.example.crud.service;

import com.example.crud.entity.Product;
import com.example.crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> saveProducts(List<Product> productList){
        return productRepository.saveAll(productList);
    }

    public List<Product> getproducts(){
        return productRepository.findAll();
    }
    public Product getproductByName(String name){
        return productRepository.findByName(name);
    }
    public Product getproductById(int id){
        return productRepository.findById(id).orElse(null);
    }
    public String deleteProduct(int id){
        productRepository.deleteById(id);
        return "Product Removed - "+id;
    }
    public Product updateProduct(Product product){
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return productRepository.save(existingProduct);
    }
}
