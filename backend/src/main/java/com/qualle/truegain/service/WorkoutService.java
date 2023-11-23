package com.qualle.truegain.service;

import com.qualle.truegain.api.SimpleWorkoutDto;
import com.qualle.truegain.api.WorkoutDto;
import com.qualle.truegain.service.basic.GenericService;

import java.util.List;
import java.util.Map;

public interface WorkoutService extends GenericService<WorkoutDto, Long> {

    WorkoutDto getByUserIdAndDate(long userId, String date);

    List<SimpleWorkoutDto> getByUserId(long userId);

    List<SimpleWorkoutDto> getRecentByUserIdWithLimit(long userId, int count);

    Map<Integer, Integer> getCountByUserIdGroupByWeekNumber(long userId);
}