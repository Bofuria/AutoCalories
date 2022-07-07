package org.example.Message;

import org.example.Message.Calories.DayTrack;
import org.example.Message.Calories.FoodItem;
import org.example.Message.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

import org.example.Message.Calories.FoodItem.*;

import static org.example.Message.Calories.ManageFoodItem.*;

@Controller
public class indexController {

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @Autowired
    Dao dao;

    @RequestMapping("addFoodItem")
    public String addFoodItem(FoodItem foodItem) throws IOException, InterruptedException {
        foodItem.setDate(LocalDate.now(ZoneId.of("Europe/Paris")).toString());

        foodItem.setTime(LocalTime.now(ZoneId.of("Europe/Paris")).toString());

        foodItem.setCaloriesValue(serverReceive(foodItem));
        
        dao.save(updateMealCount(dao, foodItem));
        return "index";
    }


    @RequestMapping("getFoodItem")
    public ModelAndView addFoodItem(@RequestParam int id) {
        ModelAndView mv = new ModelAndView("history");
        FoodItem foodItem = dao.findById(id).orElse(new FoodItem());
        mv.addObject(foodItem);
        return mv;
    }
}
