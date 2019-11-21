package com.reactive.bootstrap;

import com.reactive.model.City;
import com.reactive.service.CityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class DataLoader  implements CommandLineRunner {

    private final CityService cityService;


    @Override
    public void run(String... args) throws Exception {
        log.info("Cities oluşturudu.");

        List<City> cities = Arrays.asList(new City("Bratislava", 432000),
                new City("Budapest", 1759000),
                new City("Prague", 1280000),
                new City("Warsaw", 1748000));

        Mono<Void> one = cityService.deleteAll();

        Flux<City> two = cityService.saveAll(cities);
        Flux<City> three = cityService.findAll();
        three.subscribe(city -> log.info("{}", city));

        Mono<Void> all = Mono.when(one, two, three);
        all.block();

    }
}
