package com.code.graphql_demo.service;


import com.code.graphql_demo.model.Coach;
import com.code.graphql_demo.model.Team;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Service
public class CoachService {

    private Map<Team, Coach> coaches = new HashMap<>();

    public CoachService() {
        // Inicijalizacija trenera za svaki tim
        coaches.put(Team.CSK, new Coach(1, "Rodriguez", 10, Team.CSK));
        coaches.put(Team.PAO, new Coach(2, "Jones", 8, Team.PAO));
        coaches.put(Team.CZV, new Coach(3, "Jakson", 12, Team.CZV));
        coaches.put(Team.PAOK, new Coach(4, "Michell", 6, Team.PAOK));
    }

    public Coach findCoachByTeam(Team team) {
        return coaches.get(team);
    }

    public Coach createCoach(String name, int experience, Team team) {
        Coach coach = new Coach(coaches.size() + 1, name, experience, team);
        coaches.put(team, coach);
        return coach;
    }

    public Coach updateCoach(int id, String name, int experience, Team team) {
        Coach coach = findCoachByTeam(team);
        if (coach != null) {
            coach.setName(name);
            coach.setExperience(experience);
            coach.setTeam(team);
        } else {
            coach = new Coach(id, name, experience, team);
            coaches.put(team, coach);
        }
        return coach;
    }

    public Coach deleteCoach(int id) {
        for (Map.Entry<Team, Coach> entry : coaches.entrySet()) {
            if (entry.getValue().getId().equals(id)) {
                return coaches.remove(entry.getKey());
            }
        }
        throw new IllegalArgumentException("Coach not found");
    }

    // Ova metoda vraća sve trenere u listi
    public List<Coach> getCoaches() {
        return List.copyOf(coaches.values());
    }
}