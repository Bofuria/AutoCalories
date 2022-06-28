package org.example.Message.Calories;

import org.example.Message.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

@Component
public class ManageFoodItem extends FoodItem {
    static DayTrack dayTrack = new DayTrack();
    public static FoodItem updateMealCount(Dao dao, FoodItem foodItem) {
        if(dayTrack.dayChanged(foodItem)) {
            foodItem.setMealCount(1);
            dayTrack = new DayTrack();
        } else {
            Integer temp = dao.findByMealCount();
            if(temp != null) {
                foodItem.setMealCount(++temp);
            }
            else {
                foodItem.setMealCount(1);
            }
        }
        return foodItem;
    }

    public static void prepareRequest(String message) throws IOException, InterruptedException {
        Socket nodejs = new Socket("localhost", 8080);
        Thread.sleep(100);
        nodejs.getOutputStream().write(message.getBytes(StandardCharsets.UTF_8));
        //nodejs.getOutputStream().flush();
    }
}
