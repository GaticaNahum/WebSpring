package mx.edu.utez.MarketPlace.subCategoria.Model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
    Optional<SubCategory> findByDescription(String description);
    List<SubCategory> findSubCategoriesByCategory_Id(long id);
    boolean existsById(long id);
    boolean existsSubCategoryById(long id);//Para validad si existen sub categorias dentro de la categoria
}
