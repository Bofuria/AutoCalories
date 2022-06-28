package org.example.Message.Calories;
//import java.sql.Time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Objects;

@Component
public class DayTrack extends ListOfFood {

    String localDate;
    boolean switchDay;

    public DayTrack() {
        setLocalDate(LocalDate.now(ZoneId.of("Europe/Paris")).toString());
    }

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    public boolean isSwitchDay() {
        return switchDay;
    }

    public void setSwitchDay(boolean switchDay) {
        this.switchDay = switchDay;
    }

    public boolean dayChanged(FoodItem foodItem) {
        return !foodItem.date.equals(localDate);
    }
}