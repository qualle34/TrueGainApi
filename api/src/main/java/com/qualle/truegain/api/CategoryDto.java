package com.qualle.truegain.api;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    private long id;
    private String name;
    private String imageLink;
    private List<ExerciseDto> exercises;
}
