package com.code.graphql_demo.model;


public class Player {


    private Integer id;
    private String name;
    private Team team;
    private Position position;
    private int points;
    private int assists;
    private int rebounds;

    // Constructor
    public Player(Integer id, String name, Team team, Position position, int points, int assists, int rebounds) {
        this.id = id;
        this.name = name;
        this.team = team;
        this.position = position;
        this.points = points;
        this.assists = assists;
        this.rebounds = rebounds;
    }

    // Getters and setters
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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getRebounds() {
        return rebounds;
    }

    public void setRebounds(int rebounds) {
        this.rebounds = rebounds;
    }

    // toString method
    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", team=" + team +
                ", position=" + position +
                ", points=" + points +
                ", assists=" + assists +
                ", rebounds=" + rebounds +
                '}';
    }
    }