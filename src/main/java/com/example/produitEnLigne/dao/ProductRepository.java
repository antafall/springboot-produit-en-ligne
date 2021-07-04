package com.example.produitEnLigne.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.produitEnLigne.entities.Product;

@CrossOrigin("*")
@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {
      @RestResource(path="/promotionProduct")
      public List<Product> findByPromotionIsTrue();
      @RestResource(path="/productsByKeyword")
      public List<Product> findByNameContains(@Param("mc") String mc);

}
