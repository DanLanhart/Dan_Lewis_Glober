package com.dan_lewis_glober.controller;

import com.dan_lewis_glober.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LocationController {

    @Autowired
    private LocationService locationService;

    // display list of all locations and the corresponding details

    @RequestMapping("/about")
    public String showAllLocations(Model model) {
        model.addAttribute("listLocations", locationService.getAllLocations());
        return "about_page";
    }
}
