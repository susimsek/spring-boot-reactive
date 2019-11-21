package com.reactive.repository;

import com.reactive.model.City;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CityRepository extends ReactiveMongoRepository<City,String> {
}
