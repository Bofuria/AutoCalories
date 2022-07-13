package org.example.Message.adiitionalInfo;

import com.google.gson.Gson;
import org.example.Message.Calories.FoodItem;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BuildChart {

    public String prepareChartInfo(List<FoodItem> sqlDatSet) {

        Gson gsonObj = new Gson();
        Map<Object, Object> map = null;
        List<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();
        String dataPoints = null;

        String xVal, yVal;

        for (int i = 0; i < sqlDatSet.size(); i++) {
            xVal = sqlDatSet.get(i).getDate();
            yVal = String.valueOf(sqlDatSet.get(i).getDayCaloriesValue());

            map = new HashMap<Object, Object>();
            map.put("label", xVal);
            map.put("y", Double.parseDouble(yVal));

            list.add(map);

            dataPoints = gsonObj.toJson(list);
        }
        return dataPoints;
    }
}
