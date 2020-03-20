package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Controller
public class FreeTimeController {

    @GetMapping("freeTime")
    @ResponseBody
    public String freeTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        if (localDateTime.getDayOfWeek().equals(DayOfWeek.SATURDAY) ||
        localDateTime.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            return "Wolne";
        }

        if (localDateTime.toLocalTime().isAfter(LocalTime.of(9,0)) &&
                localDateTime.toLocalTime().isBefore(LocalTime.of(17,0))) {
            return "Pracuje, nie dzwoń.";
        }

        return "Po pracy";
    }

}
