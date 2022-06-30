package org.example.Message.Calories;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.example.Message.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestParam;

@Entity
@Table(name = "food_item")
public class FoodItem extends ListOfFood {
    @Id
    int id;
    String name;
    String date;
    String time;
    int weight;
    int caloriesValue;
    int mealCount;

    public FoodItem() {

    }

    public int getMealCount() {
        return mealCount;
    }

    public void setMealCount(int mealCount) {
        this.mealCount = mealCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "FoodItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", time='" + time + '\'' +
                ", date='" + date + '\'' +
                ", caloriesValue=" + caloriesValue +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCaloriesValue() throws IOException {
        return caloriesValue;
    }

    public void setCaloriesValue(int caloriesValue) {
        this.caloriesValue = caloriesValue;
    }

    // переименовать, переделать try catch в throws
    public Integer runJSServer() {

        ProcessBuilder pb = new ProcessBuilder("node", System.getProperty("user.dir") + "\\src\\main\\java\\org\\example\\Message\\Calories\\receive.cjs");
        try {
            Process p = pb.start();
            System.out.println("is alive: " + p.isAlive());
//            Scanner s = new Scanner(p.getInputStream());
//            String result = s.hasNext() ? s.next() : "";
//            System.out.println("result: " + result);
//            return Integer.parseInt(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

//    public Integer getCalories() {
//
//        ProcessBuilder pb = new ProcessBuilder("node", System.getProperty("user.dir") + "\\src\\main\\java\\org\\example\\Message\\Calories\\cal.cjs");
//        try {
//            Process p = pb.start();
//            System.out.println("is alive: " + p.isAlive());
////            Scanner s = new Scanner(p.getInputStream());
////            String result = s.hasNext() ? s.next() : "";
////            System.out.println("result: " + result);
////            return Integer.parseInt(result);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return 0;
//    }
}
