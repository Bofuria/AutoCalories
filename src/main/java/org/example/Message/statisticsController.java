package org.example.Message;

import org.example.Message.Calories.FoodItem;
import org.example.Message.adiitionalInfo.BuildChart;
import org.example.Message.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class statisticsController {

    final
    Dao dao;

    @Autowired
    BuildChart buildChart;

    public statisticsController(Dao dao) {
        this.dao = dao;
    }

    @RequestMapping("/history")
    public String history(Model model) {
        System.out.println("Last record calories: " + dao.findCaloriesOfLastRecord());
        List<FoodItem> foodItemList = dao.findAll();
        String foodItemChartInfo = buildChart.prepareChartInfo(dao.findByDate());

        model.addAttribute("chart", foodItemChartInfo);
        model.addAttribute("food", foodItemList);

        return "history";
    }


}
