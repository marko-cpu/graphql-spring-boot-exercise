package com.code.graphql_demo.controller;

import com.code.graphql_demo.model.Player;
import com.code.graphql_demo.model.Position;
import com.code.graphql_demo.model.Team;
import com.code.graphql_demo.service.PlayerService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;
import java.util.Optional;



@Controller
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @QueryMapping
    public List<Player> findAll() {
        return playerService.findAll();
    }

    @QueryMapping
    public Optional<Player> findOne(@Argument Integer id) {
        return playerService.findOne(id);
    }

    @QueryMapping
    public List<Player> findByTeam(@Argument Team team) {
        return playerService.findByTeam(team);
    }

    @QueryMapping
    public List<Player> findPlayersWithPointsAbove(@Argument int threshold) {
        return playerService.findPlayersWithPointsAbove(threshold);
    }


    @QueryMapping
    public List<Player> findByPosition(@Argument Position position) {
        return playerService.findByPosition(position);
    }



    @MutationMapping
    public Player create(@Argument String name, @Argument Team team, @Argument Position position, @Argument int points, @Argument int assists, @Argument int rebounds) {
        return playerService.create(name, team, position, points, assists, rebounds);
    }

    @MutationMapping
    public Player update(@Argument Integer id,@Argument String name, @Argument Team team, @Argument Position position, @Argument int points, @Argument int assists, @Argument int rebounds) {
        return playerService.update(id, name, team, position, points, assists, rebounds);
    }

    @MutationMapping
    public Player delete(@Argument Integer id,@Argument String name, @Argument Team team) {
        return playerService.delete(id);
    }

}
