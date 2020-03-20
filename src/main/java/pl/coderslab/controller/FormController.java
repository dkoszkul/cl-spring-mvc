package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("form")
public class FormController {


    @GetMapping
    public String goToMyForm(){
        return "moja-formatka.jsp";
    }

    @PostMapping
    @ResponseBody
    public String handleMyForm(@RequestParam("paramName") String paramName, @RequestParam("paramDate")String paramDate) {
        LocalDate date = LocalDate.parse(paramDate);

        return paramName + " " + date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
