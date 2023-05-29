package firstwebjavaproject.javawebproject.dto;

public class PlayerImportDTO {

    private String firstName;
    private String lastName;
    private int assists;
    private int goals;
    private PlayerProfileDTO playerProfile;
    private TeamImportDTO team;
    private CountryDTO nationality;

    public PlayerImportDTO() {
        super();
    }

    public PlayerImportDTO(String firstName, String lastName, int assists, int goals, PlayerProfileDTO playerProfile, TeamImportDTO team, CountryDTO nationality) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.assists = assists;
        this.goals = goals;
        this.playerProfile = playerProfile;
        this.team = team;
        this.nationality = nationality;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAssists() {
        return assists;
    }


    public int getGoals() {
        return goals;
    }

    public PlayerProfileDTO getPlayerProfile() {
        return playerProfile;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPlayerProfile(PlayerProfileDTO playerProfile) {
        this.playerProfile = playerProfile;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public TeamImportDTO getTeam() {
        return team;
    }

    public void setTeam(TeamImportDTO team) {
        this.team = team;
    }

    public CountryDTO getNationality() {
        return nationality;
    }

    public void getNationality(CountryDTO nationality) {
        this.nationality = nationality;
    }


}
