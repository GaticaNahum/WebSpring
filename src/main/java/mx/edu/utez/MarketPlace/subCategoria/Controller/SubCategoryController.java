package mx.edu.utez.MarketPlace.subCategoria.Controller;


import antlr.debug.MessageAdapter;
import mx.edu.utez.MarketPlace.Utils.Message;
import mx.edu.utez.MarketPlace.subCategoria.Model.SubCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subCategory")
@CrossOrigin(origins = {"*"})
public class SubCategoryController {
    @Autowired
    SubCategoryService subCategoryService;

    @GetMapping("/")
    public ResponseEntity<Message> getAll(){
        return subCategoryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getById(@PathVariable("id") long id){
        return subCategoryService.findById(id);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Message> getSubCategoriesByCategories(@PathVariable("id") long id){
        return subCategoryService.findSubCategoriesByCategory(id);
    }

    @PostMapping("/")
    public ResponseEntity<Message> insert (@RequestBody SubCategoryDTO subCategoryDTO){
        return subCategoryService.insert(new SubCategory(subCategoryDTO.getId(),subCategoryDTO.getDescription(),subCategoryDTO.getCategory(),subCategoryDTO.getStatus()));
    }

    @PutMapping("/")
    public ResponseEntity<Message> update (@RequestBody SubCategoryDTO subCategoryDTO){
        return subCategoryService.update(new SubCategory(subCategoryDTO.getId(),subCategoryDTO.getDescription(),subCategoryDTO.getCategory(),subCategoryDTO.getStatus()));
    }


}
