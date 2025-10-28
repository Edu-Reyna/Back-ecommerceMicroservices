package com.MGoldenPearl.repositories;

import com.MGoldenPearl.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {

}
