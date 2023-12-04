package com.cetys.rating.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cetys.rating.DAO.Services.RatingService;
import com.cetys.rating.DAO.Services.RestroomService;
import com.cetys.rating.DAO.Entities.RatingEntity;
import com.cetys.rating.DAO.Entities.RestroomEntity;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "false")
@RequestMapping("/api")
public class ApiControllers {

    @Autowired
    private final RatingService ratingService;
    @Autowired
    private final RestroomService restroomService;

    public ApiControllers(RatingService ratingService, RestroomService restroomService) {
        this.ratingService = ratingService;
        this.restroomService = restroomService;
    }

    /*@GetMapping("/restrooms")
    public ResponseEntity<List<RestroomEntity>> getAllRestrooms() {
        return ResponseEntity.ok(restroomService.getAllRestrooms());
    }*/
    @GetMapping("/restrooms")
    public List<RestroomEntity> getAllRestrooms() {
        return restroomService.getAllRestrooms();
    }

    @GetMapping("/restrooms/{id}")
    public ResponseEntity<RestroomEntity> getRestroomById(@PathVariable int id) {
        Optional<RestroomEntity> restroom = restroomService.getRestroomById(id);
        return restroom.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/restrooms/avg")
    public ResponseEntity<Map<RestroomEntity, Map<String, Double>>> getAverageRatingPerRestroom() {
        Map<RestroomEntity, Map<String, Double>> averageRatings = restroomService.getAverageRatingPerRestroom();
        
        if (averageRatings.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
    
        return ResponseEntity.ok(averageRatings);
    }

    @GetMapping("/restrooms/avg/{id}")
    public ResponseEntity<Map<String, Double>> getAverageRatingsById(@PathVariable int restroomId) {
        Map<String, Double> averageRatings = restroomService.getAverageRatingsById(restroomId);

        if (averageRatings == null) {
            // Manejar el caso en el que no hay calificaciones para el baño especificado
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(averageRatings);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createRating(@RequestBody RatingEntity newRating) {
        try {
            RatingEntity createdRating = ratingService.saveRating(newRating);
            return ResponseEntity.status(HttpStatus.CREATED).body("Rating created with ID: " + createdRating.getRatingId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating rating");
        }
    }
}
