package mmarini.unitn.team04_matchweb.model.RestDTO;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Championship {

    @Id
    private Integer id;

    @Column(length = 64)
    private String description;


    public Championship() {
    }

    public Championship(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}