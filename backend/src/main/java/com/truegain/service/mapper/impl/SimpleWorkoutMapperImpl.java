package com.truegain.service.mapper.impl;

import com.truegain.api.SimpleWorkoutDto;
import com.truegain.model.entity.User;
import com.truegain.model.entity.Workout;
import com.truegain.service.mapper.SimpleWorkoutMapper;
import com.truegain.service.util.DateFormatUtil;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class SimpleWorkoutMapperImpl implements SimpleWorkoutMapper {

    @Override
    public SimpleWorkoutDto toDto(Workout workout) {

        validate(workout);

        long userId = 0;

        if (workout.getUser() != null) {
            userId = workout.getUser().getId();
        }

        int exerciseCount = workout.getRecords().stream().collect(Collectors.groupingBy(w -> w.getExercise().getId())).size();


        return SimpleWorkoutDto.builder()
                .id(workout.getId())
                .userId(userId)
                .date(DateFormatUtil.toString(workout.getDate()))
                .exerciseCount(exerciseCount)
                .build();
    }

    @Override
    public Workout fromDto(SimpleWorkoutDto dto) {

        validate(dto);

        User user = User.builder().id(dto.getUserId()).build();

        return Workout.builder()
                .id(dto.getId())
                .date(DateFormatUtil.toDate(dto.getDate()))
                .user(user)
                .build();
    }
}
