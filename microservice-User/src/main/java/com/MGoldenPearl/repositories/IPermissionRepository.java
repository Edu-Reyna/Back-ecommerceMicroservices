package com.MGoldenPearl.repositories;

import com.MGoldenPearl.entities.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPermissionRepository extends JpaRepository<PermissionEntity, Long> {
}
