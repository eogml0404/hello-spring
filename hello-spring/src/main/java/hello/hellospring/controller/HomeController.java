package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {

    //Mapping된게 있으므로 이거먼저 호출
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
