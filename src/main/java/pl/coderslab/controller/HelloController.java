package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalTime;

@Controller
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("helloView")
    public String helloView(HttpServletRequest request) {
        LocalTime time = LocalTime.now();
        if (time.isAfter(LocalTime.of(8,0)) && time.isBefore(LocalTime.of(20,0))) {
            request.setAttribute("color", "black");
            request.setAttribute("backgroundColor", "white");
        } else {
            request.setAttribute("color", "white");
            request.setAttribute("backgroundColor", "black");
        }
        return "home";
    }
}
