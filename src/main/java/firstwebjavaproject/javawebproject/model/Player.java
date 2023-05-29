package firstwebjavaproject.javawebproject.model;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Table(name = "Player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "goals")
    private Integer goals;

    @Column(name = "assists")
    private Integer assists;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nationality_id")
    @JsonIgnoreProperties("players")
    private Country nationality;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_id")
    @JsonIgnoreProperties("teams")
    private Team team;


    @OneToMany(mappedBy = "player")
    @JsonIgnoreProperties("player")
    private List<PlayerAward> playerAwards = new ArrayList<>();


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private PlayerProfile playerProfile;

    public Player() {
        super();
    }

    public Player(String firstName, String lastName, Country nationality, Team team) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
        this.team = team;
        this.goals = 0;
        this.assists = 0;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Country getNationality() {
        return nationality;
    }

    @JsonProperty("nationality_id")
    public Long getNationalityId() {
        return this.nationality.getId();
    }

    @JsonProperty("team_id")
    public Long getTeamId() {
        return this.team.getId();
    }


    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    private Integer getGoals() {
        return goals;
    }

    private void setGoals(Integer goals) {
        this.goals = goals;
    }

    private Integer getAssists() {
        return assists;
    }

    private void setAssists(Integer assists) {
        this.assists = assists;
    }

    public List<PlayerAward> getPlayerAwards() {
        return playerAwards;
    }

    private void setPlayerAwards(List<PlayerAward> playerAwards) {
        this.playerAwards = playerAwards;
    }

    //add getters and setters for playerProfile
    public PlayerProfile getPlayerProfile() {
        return playerProfile;
    }

    public void setPlayerProfile(PlayerProfile playerProfile) {
        this.playerProfile = playerProfile;
    }


}

