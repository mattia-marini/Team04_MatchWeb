package mmarini.unitn.team04_matchweb.model.dto.rest;


public class Team {

    private String name;

    private int strength;

    public Team() {
    }

    public Team(String name, int strength) {
        this.name = name;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

}