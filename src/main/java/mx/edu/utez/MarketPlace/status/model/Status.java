package mx.edu.utez.MarketPlace.status.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import mx.edu.utez.MarketPlace.Category.Model.Category;
import mx.edu.utez.MarketPlace.subCategoria.Model.SubCategory;

import javax.persistence.*;
import java.util.List;

@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique =  true)
    private String description;
    @OneToMany(mappedBy = "status")
    @JsonIgnore //Sirve para que al traer todos los datos no de traiga los de status a menos que consutles el de status
    private List<Category> categories;
    @OneToMany(mappedBy = "status")
    @JsonIgnore
    private List<SubCategory> subCategories;

    public Status() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
