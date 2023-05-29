package firstwebjavaproject.javawebproject.dto;

import firstwebjavaproject.javawebproject.model.Country;

public class CountryDTO {
    private Long id;
    private String name;


    public CountryDTO() {
        super();
    }

    public CountryDTO(Country country) {
        this.id = country.getId();
        this.name = country.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
