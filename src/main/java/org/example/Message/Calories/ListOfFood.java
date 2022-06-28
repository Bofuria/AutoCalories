package org.example.Message.Calories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Component
// @ConfigurationProperties(prefix = "message")
public class ListOfFood {

    List<ListOfFood> foodList = Collections.synchronizedList(new ArrayList<ListOfFood>());
    int resultCalories;

    public ListOfFood() {

    }

    public List<ListOfFood> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<ListOfFood> foodList) {
        this.foodList = foodList;
    }

    public int getResultCalories() {
        return resultCalories;
    }

    public void setResultCalories(int resultCalories) {
        this.resultCalories = resultCalories;
    }

    public int totalCalories() {
        return 0;
    }
}
