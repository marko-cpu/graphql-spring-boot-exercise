package com.code.graphql_demo.controller;


import com.code.graphql_demo.model.Coach;
import com.code.graphql_demo.model.Team;
import com.code.graphql_demo.service.CoachService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CoachController {

    private final CoachService coachService;

    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }

    @QueryMapping
    public Coach findCoachByTeam(@Argument Team team) {
        return coachService.findCoachByTeam(team);
    }

    @QueryMapping
    public List<Coach> findAllCoaches() {
        return coachService.getCoaches(); // Koristi getCoaches metodu
    }

    @MutationMapping
    public Coach createCoach(@Argument String name, @Argument int experience, @Argument Team team) {
        return coachService.createCoach(name, experience, team);
    }

    @MutationMapping
    public Coach updateCoach(@Argument int id, @Argument String name, @Argument int experience, @Argument Team team) {
        return coachService.updateCoach(id, name, experience, team);
    }

    @MutationMapping
    public Coach deleteCoach(@Argument int id) {
        return coachService.deleteCoach(id);
    }
}