package cetys.edu.bathrat.dao.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cetys.edu.bathrat.DAO.entidades.RatingEntity;

@Repository
public interface RatingRepository extends JpaRepository<RatingEntity, Integer> {
    List<RatingEntity> getRatingById(int ratingId);    
}
