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
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "league_id")
    private League league;

    @OneToMany(mappedBy = "team")
    private Set<Player> players = new HashSet<>();



    public Team(String name, League league, Set<Player> players) {
        super();
        this.name = name;
        this.league = league;
        this.players = players;
    }

    public Integer getId() {
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

    public void setId(Integer id) {
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


}

