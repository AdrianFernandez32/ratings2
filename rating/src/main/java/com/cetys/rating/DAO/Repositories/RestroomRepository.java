package com.cetys.rating.DAO.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cetys.rating.DAO.Entities.RestroomEntity;

@Repository
public interface RestroomRepository extends JpaRepository<RestroomEntity, Integer> {
    
}
