package com.MGoldenPearl.repositories;

import com.MGoldenPearl.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findAllByCategory_Id(Long categoryId);
}
