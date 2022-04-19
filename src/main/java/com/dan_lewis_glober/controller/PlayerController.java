package com.dan_lewis_glober.controller;

import com.dan_lewis_glober.exceptions.PlayerNotFoundException;
import com.dan_lewis_glober.model.Player;
import com.dan_lewis_glober.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    // display list of employees
    @RequestMapping("/player_list")
    public String viewHomePage(Model model) {
        model.addAttribute("listPlayers", playerService.getAllPlayers());
        return "player_list";
    }

    @GetMapping("/showNewPlayerForm")
    public String showNewPlayerForm(Model model)   {
        // create model attribute to bind from data
        Player player = new Player();
        model.addAttribute("player", player);
        return "new_player";
    }

    @PostMapping("/savePlayer")
    public String savePlayer(@ModelAttribute("player") Player player)    {
        // save player to database
        playerService.savePlayer(player);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        try {
            // get employee from the service
            Player player = playerService.getPlayerById(id);
            if(player == null) {
                throw new PlayerNotFoundException();
            }
            model.addAttribute("player", player);
        } catch (PlayerNotFoundException e) {
            return "redirect:/";
        }
        // set employee as a model attribute to pre-populate the form
        return "update_player";
    }

    @GetMapping("/deletePlayer/{id}")
    public String deletePlayer(@PathVariable(value="id") long id)  {
        // call delete player method
        this.playerService.deletePlayerById(id);
        return "redirect:/";
    }
}
