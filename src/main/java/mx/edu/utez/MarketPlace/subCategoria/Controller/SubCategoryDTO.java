package mx.edu.utez.MarketPlace.subCategoria.Controller;

import mx.edu.utez.MarketPlace.Category.Model.Category;
import mx.edu.utez.MarketPlace.status.model.Status;

public class SubCategoryDTO {

    private long id;
    private String description;
    private Category category;
    private Status status;

    public SubCategoryDTO() {
    }

    public SubCategoryDTO(long id, String description, Category category, Status status) {
        this.id = id;
        this.description = description;
        this.category = category;
        this.status = status;

    }

    public SubCategoryDTO(String description, Category category, Status status) {
        this.description = description;
        this.category = category;
        this.status = status;
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
