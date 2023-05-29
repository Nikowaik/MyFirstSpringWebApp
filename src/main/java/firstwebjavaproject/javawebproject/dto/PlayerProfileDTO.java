package firstwebjavaproject.javawebproject.dto;

public class PlayerProfileDTO {
    private String position;
    private int weight;
    private int height;
    private String foot;

    public PlayerProfileDTO() {
        super();
    }

    public PlayerProfileDTO(String position, int weight, int height, String foot) {
        super();
        this.position = position;
        this.weight = weight;
        this.height = height;
        this.foot = foot;
    }

    public String getPosition() {
        return position;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public String getFoot() {
        return foot;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }


}
