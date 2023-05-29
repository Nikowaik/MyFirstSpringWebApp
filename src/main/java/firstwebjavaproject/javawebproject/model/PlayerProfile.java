package firstwebjavaproject.javawebproject.model;

import jakarta.persistence.*;

@Entity
public class PlayerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String position;

    private Integer height;

    private Integer weight;

    private String foot;


    @OneToOne(mappedBy = "playerProfile")
    private Player player;

    public PlayerProfile() {
        super();
    }

    private PlayerProfile(String position) {
        super();
        this.position = position;
    }

    private PlayerProfile(Long id, String position) {
        super();
        this.id = id;
        this.position = position;
    }

    private PlayerProfile(String position, Player player) {
        super();
        this.position = position;
        this.player = player;
    }

    private PlayerProfile(Long id, String position, Player player) {
        super();
        this.id = id;
        this.position = position;
        this.player = player;
    }

    public Long getId() {
        return id;
    }

    private String getPosition() {
        return position;
    }

    public Player getPlayer() {
        return player;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private void setPosition(String position) {
        this.position = position;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    private Integer getHeight() {
        return height;
    }

    private Integer getWeight() {
        return weight;
    }

    private String getFoot() {
        return foot;
    }

    private void setHeight(Integer height) {
        this.height = height;
    }

    private void setWeight(Integer weight) {
        this.weight = weight;
    }

    private void setFoot(String foot) {
        this.foot = foot;
    }


}
