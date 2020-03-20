package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MultiplyController {

    @GetMapping("multiply")
    public String multiply(@RequestParam(value = "size", defaultValue = "10", required = false) int size,
                           Model model) {
        model.addAttribute("size", size);
        return "multiply";
    }
}
