package firstwebjavaproject.javawebproject.services;

import firstwebjavaproject.javawebproject.dto.CountryDTO;
import firstwebjavaproject.javawebproject.dto.TeamDTO;
import firstwebjavaproject.javawebproject.model.Country;
import firstwebjavaproject.javawebproject.model.Team;
import firstwebjavaproject.javawebproject.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public List<CountryDTO> getAllCountriesAsDto() {
        List<Country> teams = countryRepository.findAll();


        return teams.stream()
                .map(CountryDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public Country getCountryById(Long id) {
        return countryRepository.findById(id).orElse(null);
    }

    @Override
    public Country getDefaultNationality() {
        Optional<Country> optionalNationality = countryRepository.findByName("Syria");
        if(optionalNationality.isPresent()) {
            return optionalNationality.get();
        } else {
            // Create default nationality if it doesn't exist
            Country defaultNationality = new Country();
            defaultNationality.setName("Syria");
            return countryRepository.save(defaultNationality);
        }
    }
}
