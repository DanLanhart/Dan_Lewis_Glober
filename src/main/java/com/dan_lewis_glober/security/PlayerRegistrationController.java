package com.dan_lewis_glober.security;

import com.dan_lewis_glober.model.Player;
import com.dan_lewis_glober.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class PlayerRegistrationController {

    @Autowired
    private PlayerService playerService;

    @ModelAttribute("player")
    public PlayerRegistrationDto playerRegistrationDto() {
        return new PlayerRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "registration";
    }

    @PostMapping
    public String registerPlayerAccount(@ModelAttribute("player")
                                            @Valid PlayerRegistrationDto playerDto, BindingResult result) {
        Player existing = playerService.findByEmail(playerDto.getEmail());
        if(existing != null) {
            result.rejectValue
                    ("email", null, "There is already a Glober account registered to that email");
        }
        if(result.hasErrors()) {
            return "registration";
        }
        playerService.save(playerDto);
        return "redirect:/registration?success";
    }
}
