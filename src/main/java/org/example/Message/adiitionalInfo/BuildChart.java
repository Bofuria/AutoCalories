package org.example.Message.adiitionalInfo;

import java.util.List;

public class BuildChart {
    String date;
    int calories;
    List<BuildChart> requiredCaloriesInfo;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
