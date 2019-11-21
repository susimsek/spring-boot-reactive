package com.reactive.service;

import com.reactive.model.City;
import com.reactive.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CityService implements ICityService {

    private final CityRepository cityRepository;

    @Override
    public Mono<City> insert(City city) {
       return cityRepository.insert(city);
    }

    @Override
    public Flux<City> saveAll(List<City> cities) {
       return cityRepository.saveAll(cities);
    }

    @Override
    public Mono<City> findById(String id) {
       return  cityRepository.findById(id);
    }

    @Override
    public Flux<City> findAll() {
        return  cityRepository.findAll();
    }

    @Override
    public Mono<Void> deleteAll() {
       return cityRepository.deleteAll();
    }
}
