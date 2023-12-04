package com.cetys.rating.DAO.Services;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetys.rating.DAO.Entities.RatingEntity;
import com.cetys.rating.DAO.Entities.RestroomEntity;
import com.cetys.rating.DAO.Repositories.RatingRepository;
import com.cetys.rating.DAO.Repositories.RestroomRepository;

@Service
public class RestroomService {
    @Autowired
    private RestroomRepository restroomRepository;

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    public RestroomService(RestroomRepository restroomRepository) {
        this.restroomRepository = restroomRepository;
    }

    // Método para guardar un nuevo baño
    public RestroomEntity saveRestroom(RestroomEntity restroom) {
        return restroomRepository.save(restroom);
    }

    // Método para obtener todos los baños
    public List<RestroomEntity> getAllRestrooms() {
        return restroomRepository.findAll();
    }

    // Método para obtener un baño por su ID
    public Optional<RestroomEntity> getRestroomById(int restroomId) {
        return restroomRepository.findById(restroomId);
    }

    // Método para actualizar un baño existente
    public RestroomEntity updateRestroom(int restroomId, RestroomEntity updatedRestroom) {
        Optional<RestroomEntity> existingRestroom = restroomRepository.findById(restroomId);

        if (existingRestroom.isPresent()) {
            RestroomEntity restroomToUpdate = existingRestroom.get();

            // Actualizar propiedades según sea necesario
            restroomToUpdate.setUbicacion(updatedRestroom.getUbicacion());

            // Guardar y devolver el baño actualizado
            return restroomRepository.save(restroomToUpdate);
        } else {
            // Manejar el caso en que el baño no exista
            return null;
        }
    }

    // Método para eliminar un baño por su ID
    public void deleteRestroomById(int restroomId) {
        restroomRepository.deleteById(restroomId);
    }

    public Map<String, Map<String, Double>> getAverageRatingPerRestroom() {
        List<RatingEntity> allRatings = ratingRepository.findAll();
    
        Map<String, List<RatingEntity>> ratingsByRestroom = allRatings.stream()
            .collect(Collectors.groupingBy(rating -> rating.getRestroom().getUbicacion()));
    
            return ratingsByRestroom.entrySet().stream()
            .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    entry -> calculateAverageRatings(entry.getValue())
            ));
    }

    public Map<String, Double> getAverageRatingsById(int restroomId) {
        List<RatingEntity> ratingsForRestroom = ratingRepository.findByRatingId(restroomId);

        if (ratingsForRestroom.isEmpty()) {
            // Manejar el caso en el que no hay calificaciones para el baño especificado
            return null; // O el manejo que prefieras, por ejemplo, podrías devolver un mapa vacío
        }

        return calculateAverageRatings(ratingsForRestroom);
    }

    private Map<String, Double> calculateAverageRatings(List<RatingEntity> ratings) {
        int totalCategories = 4; // Número total de categorías a promediar
        Map<String, Double> averageRatings = ratings.stream()
                .flatMap(rating -> Map.of(
                        "privacidad", (double) rating.getPrivacidad(),
                        "limpieza", (double) rating.getLimpieza(),
                        "comodidad", (double) rating.getComodidad(),
                        "espacio", (double) rating.getEspacio())
                        .entrySet().stream())
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.averagingDouble(Map.Entry::getValue)));

        averageRatings.put("promedio_general", averageRatings.values().stream().mapToDouble(Double::doubleValue).average().orElse(0.0));

        return averageRatings;
    }

}
