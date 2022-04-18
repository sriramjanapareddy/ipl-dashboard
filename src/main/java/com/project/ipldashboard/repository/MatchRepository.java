package com.project.ipldashboard.repository;

import java.util.List;

import com.project.ipldashboard.model.Match;

import org.springframework.data.repository.CrudRepository;

public interface MatchRepository extends CrudRepository<Match, Long>{

    //List<Match> findAllByTeam1OrTeam2(String team1, String team2);
    List<Match> findTop4ByTeam1OrTeam2OrderByDateDesc(String team1, String team2);
    
}
