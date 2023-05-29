package firstwebjavaproject.javawebproject.dto;

public class LeagueDTO {
    private Long id;
    private String name;
    private CountryDTO country;

    public LeagueDTO() {
        super();
    }

    public LeagueDTO(Long id, String name, CountryDTO country) {
        super();
        this.id = id;
        this.name = name;
        this.country = country;
    }



    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CountryDTO getCountry() {
        return country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(CountryDTO country) {
        this.country = country;
    }
}
