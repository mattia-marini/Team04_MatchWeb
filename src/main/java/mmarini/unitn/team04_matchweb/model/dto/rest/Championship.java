package mmarini.unitn.team04_matchweb.model.dto.rest;


public class Championship {

    private Integer id;

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