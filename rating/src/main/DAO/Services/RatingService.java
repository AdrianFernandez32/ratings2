package cetys.edu.bathrat.DAO.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cetys.edu.bathrat.DAO.entidades.RatingEntity;
import cetys.edu.bathrat.DAO.repositories.RatingRepository;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }
    
    public RatingEntity saveRating(RatingEntity rating) {
        return ratingRepository.save(rating);
    }

    // Método para obtener todos los ratings
    public List<RatingEntity> getAllRatings() {
        return ratingRepository.findAll();
    }

    // Método para obtener un rating por su ID
    public Optional<RatingEntity> getRatingById(int ratingId) {
        return ratingRepository.findById(ratingId);
    }

    // Método para actualizar un rating existente
    public RatingEntity updateRating(int ratingId, RatingEntity updatedRating) {
        Optional<RatingEntity> existingRating = ratingRepository.findById(ratingId);

        if (existingRating.isPresent()) {
            RatingEntity ratingToUpdate = existingRating.get();

            // Actualizar propiedades según sea necesario
            ratingToUpdate.setPrivacidad(updatedRating.getPrivacidad());
            ratingToUpdate.setLimpieza(updatedRating.getLimpieza());
            ratingToUpdate.setComodidad(updatedRating.getComodidad());
            ratingToUpdate.setEspacio(updatedRating.getEspacio());
            ratingToUpdate.setFecha(updatedRating.getFecha());

            // También puedes actualizar la relación si es necesario
            ratingToUpdate.setRestroom(updatedRating.getRestroom());

            // Guardar y devolver el rating actualizado
            return ratingRepository.save(ratingToUpdate);
        } else {
            // Manejar el caso en que el rating no exista
            return null;
        }
    }

    // Método para eliminar un rating por su ID
    public void deleteRatingById(int ratingId) {
        ratingRepository.deleteById(ratingId);
    }
}

