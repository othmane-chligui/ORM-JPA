package org.example.orm_jpa.repository;

import org.example.orm_jpa.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product,Long> {
    List<Product> findByNameContainsIgnoreCase(String word);
    @Query("select p from Product p where p.name like :x")
    List<Product> search(@Param("x") String word);

    List<Product> findByPriceGreaterThan(double price);

    @Query("select p from Product p where p.price>:x")
    List<Product> searchByPrice(@Param("x") double price);
}
