package com.qualle.truegain.repository;

import com.qualle.truegain.model.entity.Category;
import jakarta.persistence.QueryHint;
import org.hibernate.jpa.HibernateHints;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

import static org.hibernate.jpa.HibernateHints.HINT_CACHEABLE;
import static org.hibernate.jpa.HibernateHints.HINT_CACHE_MODE;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    @Query("FROM Category c LEFT JOIN FETCH c.image ORDER BY c.id")
    List<Category> findAllWithImage();

    @Query("FROM Category c LEFT JOIN FETCH c.image LEFT JOIN FETCH c.exercises e LEFT JOIN FETCH e.image LEFT JOIN FETCH e.icon ORDER BY c.id")
    @QueryHints({
            @QueryHint(name = "org.hibernate.cacheable", value = "true")
    }) // todo does not work
    List<Category> findAllWithExerciseAndImage();
}
