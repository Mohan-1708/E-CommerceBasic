package com.example.productfst.Service;

import com.example.productfst.Model.Product;
import com.example.productfst.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private Repositories repositories;

    public List<Product> getProducts() {
        return productRepo.findAll();
    }



    public Product getProductsById(int id) {

        return productRepo.findById(id).orElse(null);
    }


    public Product addProducts(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImagetype(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return productRepo.save(product);
    }


    public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException {
        product.setImageData(imageFile.getBytes());
        product.setImageName(imageFile.getOriginalFilename());
        product.setImagetype(imageFile.getContentType());
        return productRepo.save(product);
    }

    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }

    public List<Product> searchProduct(String name) {
       // System.out.println(name);
        return productRepo.searchProducts(name);

    }
}
