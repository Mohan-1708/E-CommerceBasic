package com.example.productfst.Repository;

import com.example.productfst.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

   @Query("SELECT p from Product p where " +
        "Lower(p.name) like lower(concat('%', :keyword , '%')) or "+
           "Lower(p.description) like lower(concat('%', :keyword , '%')) or "+
           "Lower(p.brand) like lower(concat('%', :keyword , '%')) or "+
           "Lower(p.category) like lower(concat('%', :keyword , '%'))")
   List<Product> searchProducts(String keyword);


}
