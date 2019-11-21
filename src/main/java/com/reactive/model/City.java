package com.reactive.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
@RequiredArgsConstructor
@Document(value="cities")
public class City {

    @Id
    private String id;

    @NonNull
    private  String name;

    @NonNull
    private  int population;

}
