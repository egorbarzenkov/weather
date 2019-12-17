package com.example.repos;

import com.example.domain.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRepo extends CrudRepository<City, Long> {

    City findByName(String name);
}
