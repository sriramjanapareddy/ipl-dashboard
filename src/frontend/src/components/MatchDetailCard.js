import { React } from 'react';
import { Link } from 'react-router-dom';
import './MatchDetailCard.scss';

export const MatchDetailCard = ({ teamName, match }) => {
    if (!match) return null;
    const otherTeam = match.team1 === teamName ? match.team2 : match.team1;
    const otherTeamRoute = `/teams/${otherTeam}`;
    const isMatchWon = match.matchWinner === teamName;
    return (
        <div className={isMatchWon ? 'MatchDetailCard won-card' : 'MatchDetailCard lost-card'}>
            <div>
            <span className='vs'>vs</span>
            <h2><Link to = {otherTeamRoute}>{otherTeam}</Link></h2>
            <h3 className='match-date'>{match.date}</h3>
            <h3 className='match-venue'>at {match.venue}</h3>
            <h4 className='match-result'>{match.matchWinner} won by {match.resultMargin} {match.result}</h4>
            </div>
            <div className='additional-detail'>
                <h4>First Innings</h4>
                <p>{match.team1}</p>
                <h4>Second Innings</h4>
                <p>{match.team2}</p>
                <h4>Man of the match</h4>
                <p>{match.playerOfMatch}</p>
            </div>
        </div>
    );
}