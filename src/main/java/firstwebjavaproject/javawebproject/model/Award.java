package firstwebjavaproject.javawebproject.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Award")
public class Award {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;


        @Column(name = "name")
        private String name;

    @OneToMany(mappedBy = "award")
    private List<PlayerAward> playerAwards = new ArrayList<>();

    @Transient
    private List<Integer> playerIds;


    //generate constructor and getter and setters
        public Award() {
            super();
        }

    private Award(String name) {
        super();
        this.name = name;
    }

    public Award(Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    private List<PlayerAward> getPlayerAwards() {
        return playerAwards;
    }

    private void setPlayerAwards(List<PlayerAward> playerAwards) {
        this.playerAwards = playerAwards;
    }

    public List<Integer> getPlayerIds() {
        return playerIds;
    }

    private void setPlayerIds(List<Integer> playerIds) {
        this.playerIds = playerIds;
    }

}
