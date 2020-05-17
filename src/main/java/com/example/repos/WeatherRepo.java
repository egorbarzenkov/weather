package com.example.repos;

import com.example.domain.Weather;
import org.springframework.data.repository.CrudRepository;

public interface WeatherRepo extends CrudRepository<Weather, Long> {
    Weather findTopByCity_IdOrderByDateDesc(Long id);
}
