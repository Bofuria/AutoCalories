package org.example.Message.dao;

import org.example.Message.Calories.FoodItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Dao extends CrudRepository<FoodItem, Integer> {
    List<FoodItem> findByDate(String date);

    @Query(value = "SELECT meal_count FROM food_item ORDER BY id DESC LIMIT 1", nativeQuery = true)
    Integer findByMealCount();
}
