package com.example.springbootcrud.service;

import com.example.springbootcrud.entity.Product;
import com.example.springbootcrud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // method to save a product
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // method to save multiple products
    public List<Product> saveProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    // method to get all products
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    // method to get a product by id
    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    // method to get a product by name
    public Product getProductByName(String name) {
        return productRepository.findByName(name);
    }

    // method to delete a product
    public String deleteProduct(int id) {
        productRepository.deleteById(id);
        return "Product removed !! " + id;
    }

    // method to update a product
    public Product updateProduct(Product product) {
        // get product based on id
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
        // updating the product
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());

        // saving the new product
        return productRepository.save(existingProduct);
    }
}
