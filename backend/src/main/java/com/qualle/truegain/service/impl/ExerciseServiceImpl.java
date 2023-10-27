package com.qualle.truegain.service.impl;

import com.qualle.truegain.api.CategoryDto;
import com.qualle.truegain.api.ExerciseDto;
import com.qualle.truegain.model.entity.Exercise;
import com.qualle.truegain.repository.CategoryRepository;
import com.qualle.truegain.repository.ExerciseRepository;
import com.qualle.truegain.service.ExerciseService;
import com.qualle.truegain.service.mapper.CategoryMapper;
import com.qualle.truegain.service.mapper.ExerciseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;
    private final CategoryRepository categoryRepository;
    private final ExerciseMapper exerciseMapper;
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryDto> getCategories() {
        List<CategoryDto> result = new ArrayList<>();

        categoryRepository.findAll()
                .forEach(c -> result.add(categoryMapper.toDto(c)));

        return result;
    }

    @Override
    public List<ExerciseDto> getExercisesByCategory(long categoryId) {
        return null;
    }

    @Override
    public List<ExerciseDto> getExercise(long id) {
        return null;
    }

    @Override
    public List<ExerciseDto> getExerciseWithRecordsByWorkoutId(long workoutId) {
        return exerciseMapper.toDto(exerciseRepository.findAllExercisesWithRecordsByWorkoutId(workoutId));
    }
}
