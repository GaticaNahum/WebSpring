package mx.edu.utez.MarketPlace.subCategoria.Controller;

import mx.edu.utez.MarketPlace.Utils.Message;
import mx.edu.utez.MarketPlace.subCategoria.Model.SubCategory;
import mx.edu.utez.MarketPlace.subCategoria.Model.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Optional;

@Service
@Transactional
public class SubCategoryService {
    @Autowired
    SubCategoryRepository subCategoryRepository;
    //ctrol + alt +l formato
    @Transactional(readOnly = true)
    public ResponseEntity<Message> findAll(){
        return new ResponseEntity<>(new Message("OK", false, subCategoryRepository.findAll()), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findById(long id){
        if(subCategoryRepository.existsById(id)){
            return new ResponseEntity<>(new Message("OK", false, subCategoryRepository.findById(id)), HttpStatus.OK);
        }

        return new ResponseEntity<>(new Message("La subcategoria no existe", true, null), HttpStatus.BAD_REQUEST);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findSubCategoriesByCategory(long id){
        if(subCategoryRepository.existsSubCategoryById(id)){
            return new ResponseEntity<>(new Message("OK", false, subCategoryRepository.findSubCategoriesByCategory_Id(id)),
                    HttpStatus.OK);
        }

        return new ResponseEntity<>(new Message("La categoria no tiene subcatgorias", true, null), HttpStatus.BAD_REQUEST);
    }


    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> insert(SubCategory subCategory){
        Optional<SubCategory> existSubcategory = subCategoryRepository.findByDescription(subCategory.getDescription());
        if(existSubcategory.isPresent()){
            return new ResponseEntity<>(new Message("La subcategoria ya existe", true, null), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new Message("Subcategoria registrada correctamente", false, subCategoryRepository.saveAndFlush(subCategory)), HttpStatus.OK);
    }


    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> update(SubCategory subCategory){
        if(subCategoryRepository.existsById(subCategory.getId())){
            return new ResponseEntity<>(new Message("La subcategoria ya existe", true, null), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new Message("Subcategoria actualizada correctamente", false, subCategoryRepository.saveAndFlush(subCategory)), HttpStatus.OK);
    }



}
