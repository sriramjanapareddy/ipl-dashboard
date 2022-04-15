package com.project.ipldashboard.controller;

import com.project.ipldashboard.model.Team;
import com.project.ipldashboard.repository.TeamRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {

    @Autowired
    TeamRepository teamRepository;
    

    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName) {
        
        return teamRepository.findByTeamName(teamName);
    }

    
    
}
