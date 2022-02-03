package mx.edu.utez.MarketPlace.Category.Controller;
//En esta clase se maneja toda la lógica del repositorio

import mx.edu.utez.MarketPlace.Category.Model.Category;
import mx.edu.utez.MarketPlace.Category.Model.CategoryRepository;
import mx.edu.utez.MarketPlace.Utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.sql.SQLException;
import java.util.Optional;

@Service
@Transactional //Se llama por que se inicia la transacción y si el alguna instrucción ocurre algun error la va a devolver, es secuencial, o sea
                //si una de las operaciones no se hizo correctamente no importa el orden ninguna se aplica
                // si tenemos 5 pasos y ya va por el 4 y falla, se cancelan los anteriores
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Transactional
    public ResponseEntity<Message> findAll(){
        return new ResponseEntity<>(new Message("OK",false,categoryRepository.findAll()), HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SQLException.class}) //Si encuentra un error en una parte del código la va a devolver como si no hubiera hecho nada
    public ResponseEntity <Message> update(Category category){
        if (categoryRepository.existsById(category.getId())){
            return new ResponseEntity<>(new Message("Ok", false,categoryRepository.saveAndFlush(category)),HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("La categoria no existe",true,null),HttpStatus.BAD_REQUEST);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findById(long id){
        if(categoryRepository.existsById(id)){
            return new ResponseEntity<>(new Message("OK",false, categoryRepository.findById(id)),HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("La categoria no existe",true,null),HttpStatus.BAD_REQUEST);
    }

    @Transactional(rollbackFor = {SQLException.class}) //Si encuentra un error en una parte del código la va a devolver como si no hubiera hecho nada
    public ResponseEntity <Message> save(Category category){
        Optional<Category> existCategory = categoryRepository.findByDescription(category.getDescription());
        if (existCategory.isPresent()){
            return new ResponseEntity<>(new Message("La categoria ya existe", true,null),HttpStatus.BAD_REQUEST);
        }
        Category savedCategory = categoryRepository.saveAndFlush(category);
        return new ResponseEntity<>(new Message("Categoria creada con exito",false,savedCategory),HttpStatus.OK);
    }
}
