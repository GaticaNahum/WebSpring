package mx.edu.utez.MarketPlace.Category.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import mx.edu.utez.MarketPlace.status.model.Status;
import mx.edu.utez.MarketPlace.subCategoria.Model.SubCategory;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "text", unique = true) //Eso es para que si tienen el mismo nombre no deje insertar mas de una, o sea que no se repitan
    private String description;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;
    @NotNull
    @OneToMany (mappedBy = "category")
    @JsonIgnore
    private List<SubCategory> subCategoryList;

    public Category() {
    }

    public Category(long id, String description, Status status) {
        this.id = id;
        this.description = description;
        this.status = status;
    }

    public Category(String description, Status status) {
        this.description = description;
        this.status = status;
    }


    public Category(String description) {
        this.description = description;
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
}
