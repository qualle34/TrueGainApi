package com.qualle.truegain.repository;

import com.qualle.truegain.model.entity.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    @Query("FROM Category c LEFT JOIN FETCH c.image ORDER BY c.id")
    List<Category> findAllWithImage();

    @Query("FROM Category c LEFT JOIN FETCH c.image LEFT JOIN FETCH c.exercises e LEFT JOIN FETCH e.image ORDER BY c.id")
    List<Category> findAllWithExerciseAndImage();
}