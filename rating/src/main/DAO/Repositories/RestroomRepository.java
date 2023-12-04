package cetys.edu.bathrat.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cetys.edu.bathrat.DAO.entidades.RestroomEntity;

@Repository
public interface RestroomRepository extends JpaRepository<RestroomEntity, Integer> {
    
}
