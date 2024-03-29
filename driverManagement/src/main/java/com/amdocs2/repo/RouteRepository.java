package com.amdocs2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.amdocs2.entity.RouteEntity;

@Repository
public interface RouteRepository extends JpaRepository<RouteEntity, Long>{

}
