package firstwebjavaproject.javawebproject.services;

import firstwebjavaproject.javawebproject.model.Country;
import firstwebjavaproject.javawebproject.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CountryServiceImpl implements CountryService{
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public void saveCountry(Country country) {
        this.countryRepository.save(country);
    }
}
