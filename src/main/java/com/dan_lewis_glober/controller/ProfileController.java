package com.dan_lewis_glober.controller;

import com.dan_lewis_glober.model.BugReport;
import com.dan_lewis_glober.model.Chat;
import com.dan_lewis_glober.model.Player;
import com.dan_lewis_glober.repository.PlayerRepository;
import com.dan_lewis_glober.service.ChatService;
import com.dan_lewis_glober.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class ProfileController {

    private PlayerService playerService;

    @Autowired
    private ChatService chatService;

    @Autowired
    public ProfileController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/profile")
    public String greeting(Principal principal, Model model) {
        Player player = playerService.findByEmail(principal.getName());
        model.addAttribute("username", player.getUsername());
        model.addAttribute("firstName", player.getFirstName());
        model.addAttribute("email", player.getEmail());
        model.addAttribute("password", player.getPassword());
        model.addAttribute("player", player);
        model.addAttribute("listChat", chatService.getAllChatMessages());
        return "player_profile_page";
    }

    @GetMapping("/chatForm")
    public String showChatForm(Model model, Principal principal)   {
        Player player = playerService.findByEmail(principal.getName());
        model.addAttribute("username", player.getUsername());
        model.addAttribute("email", player.getEmail());
        // create model attribute to bind from data
        Chat chat = new Chat();
        chat.setPlayer(player);
        model.addAttribute("chat", chat);
        return "chat_page";
    }

    @PostMapping("/saveChat/{email}")
    public String saveChat(@PathVariable String email, @ModelAttribute("chat") Chat chat) {
        System.out.println(email + " " + chat.getMessage());
        // save chat to database
        Player player = playerService.findByEmail(email);
        player.getChat().add(chat);
        chat.setPlayer(player);
        chatService.saveChat(chat);
        playerService.savePlayer(player);
        return "redirect:/profile";
    }
}
