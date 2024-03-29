package com.qualle.truegain.api;

import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MainPageDataDto {

    private List<WorkoutPerWeekDto> workoutPerWeekChartData;
    private List<SimpleWorkoutDto> recentWorkouts;
    private MuscleDistributionChartDto muscleDistributionChartData;
    private List<SimpleExerciseDto> frequentExercises;
}
