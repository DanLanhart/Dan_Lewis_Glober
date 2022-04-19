package com.dan_lewis_glober.service;

import com.dan_lewis_glober.model.Player;
import com.dan_lewis_glober.security.PlayerRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface PlayerService extends UserDetailsService {

    List<Player> getAllPlayers();

    void savePlayer(Player player);

    Player getPlayerById(long id);

    void deletePlayerById(long id);

    Player findByEmail(String email);

    Player save(PlayerRegistrationDto registration);
}
