package com.dan_lewis_glober.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {

    @GetMapping("/index")
    public String howToPlay(Model model) {
        return "index";
    }

    @GetMapping("/landing")
    public String landingPage(Model model)  {
        return "/landing_page";
    }

    @GetMapping("/play")
    public String play(Model mode) {
        return "game_page";
    }

    @GetMapping("/about")
    public String about(Model model) {
        return "about_page";
    }
}
