package com.project.ipldashboard.repository;

import java.time.LocalDate;
import java.util.List;

import com.project.ipldashboard.model.Match;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MatchRepository extends CrudRepository<Match, Long>{

    List<Match> findTop4ByTeam1OrTeam2OrderByDateDesc(String team1, String team2);

    @Query("select m from Match m where ((m.team1 = :teamName or m.team2 = :teamName) and (m.date between :start and :end)) order by m.date desc")
    List<Match> getMatchesByTeamBetweenDates(
        @Param("teamName") String teamName,
        @Param("start") LocalDate start,
        @Param("end") LocalDate end);
    
}
