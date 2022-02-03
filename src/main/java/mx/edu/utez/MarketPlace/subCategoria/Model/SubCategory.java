package mx.edu.utez.MarketPlace.subCategoria.Model;

import mx.edu.utez.MarketPlace.Category.Model.Category;
import mx.edu.utez.MarketPlace.status.model.Status;

import javax.persistence.*;

@Entity
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String description;
    @ManyToOne// las relaciones salen de la nueva tabla creada por ejemplo
    //MUCHAS subcategorias tienen una categoría y una categoria tiene muhcas subcategorias
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne//Muchas subcategorías tienen un status y un estado tiene muchas subcategorias
    @JoinColumn(name = "status_id")
    private Status status;

    public SubCategory() {
    }

    public SubCategory(long id, String description, Category category, Status status) {
        this.id = id;
        this.description = description;
        this.category = category;
        this.status = status;
    }

    public SubCategory(String description, Category category, Status status) {
        this.description = description;
        this.category = category;
        this.status = status;
    }

    public SubCategory(long id, String description, Status status) {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
