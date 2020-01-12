package com.example.repos;

import com.example.domain.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRepo extends CrudRepository<City, Long> {

    City findCityByName(String name);
    City findCityById(Long id);
}
