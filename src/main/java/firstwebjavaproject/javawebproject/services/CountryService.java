package firstwebjavaproject.javawebproject.services;

import firstwebjavaproject.javawebproject.model.Country;

import java.util.List;

public interface CountryService {
     List<Country> getAllCountries();
     void saveCountry(Country country);
}


