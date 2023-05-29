package firstwebjavaproject.javawebproject.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "PlayerAward")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class PlayerAward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "player_id")
    @JsonIgnoreProperties("playerAwards")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "award_id")
    private Award award;

    @Column(name = "date")
    private LocalDate date;  // the date when the player received the award

    public PlayerAward() {
        super();
    }

    private PlayerAward(Player player, Award award, LocalDate date) {
        super();
        this.player = player;
        this.award = award;
        this.date = date;
    }

    private PlayerAward(Integer id, Player player, Award award, LocalDate date) {
        super();
        this.id = id;
        this.player = player;
        this.award = award;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public Player getPlayer() {
        return player;
    }

    private Award getAward() {
        return award;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setAward(Award award) {
        this.award = award;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


}
