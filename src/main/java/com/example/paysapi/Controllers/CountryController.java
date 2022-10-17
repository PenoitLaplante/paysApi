package com.example.paysapi.Controllers;


import com.example.paysapi.Model.Country;
import com.example.paysapi.Service.CountryService;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
// @RequestMapping
public class CountryController {

    CountryService  countryService = new CountryService();


/*    //Field injection pas bon?
    @Autowired
    CountryService countryService;*/

    @GetMapping("/getcountries")
    public List getCountries(){
        return countryService.getAllCountries();
    }

    @GetMapping("/getcountries/{id}")
    public Country getCountriesById(@PathVariable(value="id")int id){

        return countryService.getCountrybyID(id);
    }

    @GetMapping("/getcountries/countryname")
    public Country getCountriesById(@RequestParam(value="name") String countryName){

        return countryService.getCountrybyName(countryName);
    }

   @PostMapping("/addcountry")
    public Country  addCountry(@RequestBody Country country){
       return  countryService.addCountry(country);

   }

    @PutMapping("/updatecountry")
    public Country  updateCountry(@RequestBody Country country){
        return  countryService.addCountry(country);

    }

    @DeleteMapping("/deletecountry{id}")
    public AddResponse deleteCountry(@PathVariable(value="id")int id){
        return countryService.deleteCountry(id);
    }

}
