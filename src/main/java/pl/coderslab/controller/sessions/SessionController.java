package pl.coderslab.controller.sessions;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDateTime;

@Controller
@SessionAttributes("loginStart")
public class SessionController {

    @GetMapping("session")
    @ResponseBody
    public String session(Model model) {
        if (model.containsAttribute("loginStart")) {
            return (String) model.asMap().get("loginStart");
        }
        String s = LocalDateTime.now().toString();
        model.addAttribute("loginStart", s);
        return s;
    }
}
