package com.code.graphql_demo.service;

import com.code.graphql_demo.model.Player;
import com.code.graphql_demo.model.Position;
import com.code.graphql_demo.model.Team;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


@Service
public class PlayerService {

    private List<Player> players = new ArrayList<>();

    AtomicInteger id = new AtomicInteger(0);

    public List<Player> findAll() {
        return players;
    }

    public Optional<Player> findOne(Integer id) {
        return players.stream()
                .filter(player -> player.getId() == id).findFirst();
    }

    public List<Player> findByTeam(Team team) {
        return players.stream()
                .filter(player -> player.getTeam() == team)
                .toList();
    }


    public List<Player> findByPosition(Position position) {
        return players.stream()
                .filter(player -> player.getPosition() == position)
                .toList();
    }

    public List<Player> findPlayersWithPointsAbove(int threshold) {
        return players.stream()
                .filter(player -> player.getPoints() > threshold)
                .toList();
    }





    public Player create(String name, Team team, Position position, int points, int assists, int rebounds) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (team == null) {
            throw new IllegalArgumentException("Team cannot be null");
        }
        Player player = new Player(id.incrementAndGet(), name, team, position, points, assists, rebounds);
        players.add(player);
        return player;
    }



    public Player delete(Integer id) {
        Player player = players.stream()
                .filter(p -> p.getId() == id).findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
        players.remove(player);
        return player;
    }

    public Player update(Integer id, String name, Team team, Position position, int points, int assists, int rebounds) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (team == null) {
            throw new IllegalArgumentException("Team cannot be null");
        }
       Player updatedPlayer = new Player(id, name, team, position, points, assists, rebounds);
       Optional<Player> optional = players.stream()
               .filter(p -> p.getId() == id).findFirst();
       if(optional.isPresent()){
           Player player = optional.get();
           int index = players.indexOf(player);
           players.set(index, updatedPlayer);

       } else {
           throw new IllegalArgumentException("Invalid Player");
       }
        return updatedPlayer;
    }

    @PostConstruct
    private void init() {
        players.add(new Player(id.incrementAndGet(), "Lebron", Team.CSK, Position.CENTER, 22, 2, 1));
        players.add(new Player(id.incrementAndGet(), "Panter", Team.PAO, Position.POINT_GUARD, 2, 0, 0));
        players.add(new Player(id.incrementAndGet(), "Teodosic", Team.CZV, Position.POWER_FORWARD, 1, 1, 0));
        players.add(new Player(id.incrementAndGet(), "Jokic", Team.PAOK, Position.SHOOTING_GUARD, 17, 5, 5));
        players.add(new Player(id.incrementAndGet(), "Petrovic", Team.PAO, Position.SHOOTING_GUARD, 17, 5, 5));

    }
}
