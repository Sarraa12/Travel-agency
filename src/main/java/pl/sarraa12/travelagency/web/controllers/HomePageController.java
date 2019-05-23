package pl.sarraa12.travelagency.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {

    @RequestMapping("/")
    public String prepareSearchPage() {

        return "home";
    }

}
