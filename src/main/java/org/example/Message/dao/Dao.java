package org.example.Message.dao;

import org.example.Message.Calories.FoodItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Dao extends CrudRepository<FoodItem, Integer> {
    @Query(value = "SELECT meal_count FROM food_item ORDER BY id DESC LIMIT 1", nativeQuery = true)
    Integer findByMealCount();

    @Query(value = "SELECT day_calories_value FROM food_item ORDER BY id DESC LIMIT 1", nativeQuery = true)
    Integer findCaloriesOfLastRecord();

    @Query(value = "SELECT date FROM food_item ORDER BY id DESC LIMIT 1", nativeQuery = true)
    String findDateOfLastRecord();

    @Query(value = "SELECT * FROM food_item ORDER BY id DESC", nativeQuery = true)
    List<FoodItem> findAll();

    @Query(value = "SELECT * FROM autocalcdb.food_item \n" +
            "WHERE id IN \n" +
            "(Select max(id) from autocalcdb.food_item group by date) ORDER BY id DESC LIMIT 7;", nativeQuery = true)
    List<FoodItem> findByDate();

}
