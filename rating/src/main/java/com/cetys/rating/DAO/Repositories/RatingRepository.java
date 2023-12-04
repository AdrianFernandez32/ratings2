package com.cetys.rating.DAO.Repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cetys.rating.DAO.Entities.RatingEntity;

@Repository
public interface RatingRepository extends JpaRepository<RatingEntity, Integer> {
    List<RatingEntity> getRatingById(int ratingId);    
}
