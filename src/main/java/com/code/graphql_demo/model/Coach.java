package com.code.graphql_demo.model;

public class Coach {
    private Integer id;
    private String name;
    private int experience; // Godine iskustva
    private Team team;  // Reference na tim

    public Coach(Integer id, String name, int experience, Team team) {
        this.id = id;
        this.name = name;
        this.experience = experience;
        this.team = team;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", experience=" + experience +
                ", team=" + team +
                '}';
    }
}
