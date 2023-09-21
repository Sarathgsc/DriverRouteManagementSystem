package com.amdocs2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amdocs2.entity.DriverEntity;

@Repository
public interface DriverRepository extends JpaRepository<DriverEntity,Integer>{

}
