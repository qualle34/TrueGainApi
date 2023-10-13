package com.qualle.shapeup.web;

import com.qualle.shapeup.api.SimpleWorkoutDto;
import com.qualle.shapeup.api.WorkoutDto;
import com.qualle.shapeup.model.exception.BadRequestException;
import com.qualle.shapeup.service.WorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WorkoutController {

    private final WorkoutService workoutService;

    @GetMapping("/workout/{id}")
    public WorkoutDto getWorkout(@PathVariable Long id) {

        if (id == 0) {
            throw new BadRequestException();
        }

        return workoutService.getById(id);
    }

    @GetMapping("/workout/simple")
    public List<SimpleWorkoutDto> getWorkoutByUserId(@RequestParam Long userId) {

        if (userId == 0) {
            throw new BadRequestException();
        }

        return workoutService.getByUserId(userId);
    }

    @GetMapping("/workout")
    public WorkoutDto getWorkoutByUserIdAndDate(@RequestParam Long userId, @RequestParam String date) {

        if (userId == 0) {
            throw new BadRequestException();
        }

        if (date == null || date.isEmpty()) {
            throw new BadRequestException();
        }

        return workoutService.getByUserIdAndDate(userId, date);
    }

    @PostMapping("/workout")
    public void addWorkout(@RequestBody @Validated WorkoutDto dto) {
        workoutService.save(dto);
    }

    @PutMapping("/workout/{id}")
    public void updateWorkout(@RequestParam @Validated Long userId, @RequestBody WorkoutDto dto) {

        if (userId == 0) {
            throw new BadRequestException();
        }

        workoutService.save(dto);
    }

    @DeleteMapping("/workout/{id}")
    public void deleteWorkout(@PathVariable Long id) {

        if (id == 0) {
            throw new BadRequestException();
        }

        workoutService.delete(id);
    }
}
