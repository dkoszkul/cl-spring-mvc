package pl.coderslab.controller.sessions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CookieController {

    @GetMapping("setcookie/{value1}/{value2}")
    @ResponseBody
    public void setCookies(@PathVariable("value1")String value1,
                           @PathVariable("value2")String value2,
                           HttpServletResponse response) {
        Cookie cookie = new Cookie("cookie1", value1);
        cookie.setPath("/");

        Cookie cookie2 = new Cookie("cookie2", value2);
        cookie2.setPath("/");

        response.addCookie(cookie);
        response.addCookie(cookie2);
    }

    @GetMapping("getcookies")
    @ResponseBody
    public String getCookies(@CookieValue("cookie1") String cookie1Value,
                             HttpServletRequest request) {
        Cookie cookie2 = WebUtils.getCookie(request, "cookie2");

        return "Cookie1: " + cookie1Value + ", Cookie2: " + cookie2.getValue();
    }
}
