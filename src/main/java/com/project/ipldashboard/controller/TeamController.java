package com.project.ipldashboard.controller;

import java.time.LocalDate;
import java.util.List;

import com.project.ipldashboard.model.Match;
import com.project.ipldashboard.model.Team;
import com.project.ipldashboard.repository.MatchRepository;
import com.project.ipldashboard.repository.TeamRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TeamController {

    @Autowired
    TeamRepository teamRepository;
    @Autowired MatchRepository matchRepository;
    

    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName) {
        Team team = teamRepository.findByTeamName(teamName);
        team.setMatches(matchRepository.findTop4ByTeam1OrTeam2OrderByDateDesc(teamName, teamName));
        return team;
    }

    @GetMapping("/team/{teamName}/matches")
    public List<Match> getMatchesForYear(@PathVariable String teamName, @RequestParam Integer year) {

        LocalDate startDate = LocalDate.of(year, 1, 1);
        LocalDate endDate = LocalDate.of(year, 12, 31);

        return matchRepository
        .getMatchesByTeamBetweenDates(teamName, startDate, endDate);
        
    }

    
    
}
