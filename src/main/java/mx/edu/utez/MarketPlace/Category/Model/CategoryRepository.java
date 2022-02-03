package mx.edu.utez.MarketPlace.Category.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByDescription(String desciption); //->Este metodos nos sirve como su nombre a buscar la categoria que tenga tal descripcion
    boolean existsById(long id);
}
