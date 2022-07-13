package org.example.Message.Calories;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.*;


@Entity
@Table(name = "food_item")
public class FoodItem {
    @Id
    int id;
    String name;
    String date;
    String time;
    int weight;
    int caloriesValue;

    int dayCaloriesValue;

    int mealCount;

    public FoodItem() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getMealCount() {
        return mealCount;
    }

    public int getDayCaloriesValue() {
        return dayCaloriesValue;
    }

    public void setDayCaloriesValue(int dayCaloriesValue) {
        this.dayCaloriesValue = dayCaloriesValue;
    }


    public void setMealCount(int mealCount) {
        this.mealCount = mealCount;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCaloriesValue() throws IOException {
        return caloriesValue;
    }

    public void setCaloriesValue(int caloriesValue) {
        this.caloriesValue = caloriesValue;
    }


}
