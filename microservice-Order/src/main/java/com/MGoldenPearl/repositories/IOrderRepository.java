package com.MGoldenPearl.repositories;

import com.MGoldenPearl.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderRepository extends JpaRepository<OrderEntity, Long> {

    List<OrderEntity> findOrderEntitiesByCustomerId(Long customerId);
}
