package com.MGoldenPearl.repositories;

import com.MGoldenPearl.entities.OrderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderDetailsRepository extends JpaRepository<OrderDetailsEntity, Long>{
}
