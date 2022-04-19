package com.dan_lewis_glober.controller;

import com.dan_lewis_glober.model.BugReport;
import com.dan_lewis_glober.model.Chat;
import com.dan_lewis_glober.model.Player;
import com.dan_lewis_glober.repository.PlayerRepository;
import com.dan_lewis_glober.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class ProfileController {

    private PlayerRepository playerRepository;

    @Autowired
    private ChatService chatService;

    public ProfileController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @GetMapping("/profile")
    public String greeting(Principal principal, Model model) {
        Player player = playerRepository.findByEmail(principal.getName());
        model.addAttribute("username", player.getUsername());
        model.addAttribute("firstName", player.getFirstName());
        model.addAttribute("email", player.getEmail());
        model.addAttribute("password", player.getPassword());
        model.addAttribute("player", player);
        model.addAttribute("listChat", chatService.getAllChatMessages());
        return "player_profile_page";
    }

    @GetMapping("/showChatForm")
    public String showChatForm(Model model)   {
        // create model attribute to bind from data
        Chat chat = new Chat();
        model.addAttribute("chat", chat);
        return "chat_page";
    }

    @PostMapping("/saveChat")
    public String saveChat(@ModelAttribute("chat") Chat chat) {
        // save bug report to database
        chatService.saveChat(chat);
        return "redirect:/profile";
    }

}
