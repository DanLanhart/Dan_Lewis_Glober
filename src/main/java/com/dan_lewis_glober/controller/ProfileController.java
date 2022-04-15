package com.dan_lewis_glober.controller;

import com.dan_lewis_glober.TESTsecurity.Player;
import com.dan_lewis_glober.TESTsecurity.PlayerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class ProfileController {

    private PlayerRepository playerRepository;

    public ProfileController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @GetMapping("/profile")
    public String greeting(Principal principal, Model model) {
        Player player = playerRepository.findByEmail(principal.getName());
        model.addAttribute("username", player.getUsername());
        model.addAttribute("firstName", player.getFirstName());
        model.addAttribute("email", player.getEmail());
        model.addAttribute("player", player);
        return "player_profile_page";
    }
}
