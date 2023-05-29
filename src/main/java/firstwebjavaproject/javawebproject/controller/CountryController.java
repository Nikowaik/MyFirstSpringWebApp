package firstwebjavaproject.javawebproject.controller;

import firstwebjavaproject.javawebproject.model.Country;
import firstwebjavaproject.javawebproject.services.CountryService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CountryController {
    @Autowired
    private CountryService countryService;
    @GetMapping("/countries.html")
    public String viewHomePage(@NotNull Model model){

        model.addAttribute("listCountries",countryService.getAllCountries());
        return "countries";
    }

    @GetMapping("/showNewCountryForm")
        public String showNewCountryForm(Model model) {
            Country country = new Country();
        model.addAttribute("country",country);
        return "new_country";
    }


    @PostMapping("/saveCountry")
    public String saveCountry(@ModelAttribute("country") @Validated Country country, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "new_country"; //replace this with your form page
        }

        try {
            countryService.saveCountry(country);
        } catch (DataIntegrityViolationException ex) {
            result.rejectValue("name", "error.country", "Country already exists");
            return "new_country"; //replace this with your form page
        }

        return "redirect:/countries.html";
    }

}