package firstwebjavaproject.javawebproject.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "points")
    private Integer points;

    @Column(name = "wins")
    private Integer wins;

    @Column(name = "draws")
    private Integer draws;

    @Column(name = "losses")
    private Integer losses;

    @Column(name = "goals_for")
    private Integer goalsFor;

    @Column(name = "goals_against")
    private Integer goalsAgainst;

    @Column(name = "goal_difference")
    private Integer goalDifference;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "league_id")
    private League league;

    @OneToMany(mappedBy = "team")
    private Set<Player> players = new HashSet<>();


    public Team() {
    }

    public Team(String name,Integer points,Integer wins, Integer draws,Integer losses,
                Integer goalsFor, Integer goalsAgainst,Integer goalDifference,League league, Set<Player> players) {
        super();
        this.name = name;
        this.wins=wins;
        this.draws=draws;
        this.losses=losses;
        this.goalsFor=goalsFor;
        this.goalsAgainst=goalsAgainst;
        this.goalDifference=goalDifference;
        this.league = league;
        this.players = players;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public League getLeague() {
        return league;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public Integer getWins(){
       return wins;
    }

    public Integer getDraws(){
        return draws;
    }

    public Integer getLosses(){
        return losses;
    }

    public Integer getGoalsFor(){
        return goalsFor;
    }

    public Integer getGoalsAgainst(){
        return goalsAgainst;
    }

    public Integer getGoalDifference(){
        return goalDifference;
    }
}

