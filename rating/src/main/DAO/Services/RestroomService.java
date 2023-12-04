package cetys.edu.bathrat.DAO.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import cetys.edu.bathrat.DAO.entidades.RestroomEntity;
import cetys.edu.bathrat.DAO.repositories.RestroomRepository;

public class RestroomService {
    private final RestroomRepository restroomRepository;

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
}
