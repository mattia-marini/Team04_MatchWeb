package mmarini.unitn.team04_matchweb.model.RestDTO;


public class ChampionshipNew {

    private int id;

    private String description;

    public ChampionshipNew(String description, int id) {
        this.description = description;
        this.id = id;
    }

    public ChampionshipNew() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
