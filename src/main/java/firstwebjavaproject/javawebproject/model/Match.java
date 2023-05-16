package firstwebjavaproject.javawebproject.model;


import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "Match")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "home_team_id")
    private Team homeTeam;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "away_team_id")
    private Team awayTeam;

    @Column(name = "home_team_score")
    private Integer homeTeamScore;

    @Column(name = "away_team_score")
    private Integer awayTeamScore;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "league_id")
    private League league;

    @Enumerated(EnumType.STRING)
    @Column(name = "match_state")
    private MatchState matchState;

    public Match() {
        super();
    }

    public Match(Team homeTeam, Team awayTeam, LocalDate date, League league) {
        super();
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.date = date;
        this.league = league;
    }

    public Match(Team homeTeam, Team awayTeam, Integer homeTeamScore, Integer awayTeamScore, LocalDate date, League league) {
        this(homeTeam, awayTeam, date, league);
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Integer getHomeTeamScore() {
        return homeTeamScore;
    }

    public Integer getLeagueId(){
        return this.league.getId();
    }

    public void setHomeTeamScore(Integer homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public Integer getAwayTeamScore() {
        return awayTeamScore;
    }

    public void setAwayTeamScore(Integer awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public MatchState getMatchState() {
        return matchState;
    }

    public void setMatchState(MatchState matchState) {
        this.matchState = matchState;
    }

    public Long getHomeTeamId(){
       return this.homeTeam.getId();
    }

    public Long getAwayTeamId(){
        return this.awayTeam.getId();
    }

    public enum MatchState {
        Finished,
        ToBePlayed
    }
}
