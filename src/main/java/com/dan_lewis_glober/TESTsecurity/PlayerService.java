package com.dan_lewis_glober.TESTsecurity;

import com.dan_lewis_glober.TESTsecurity.Player;
import com.dan_lewis_glober.TESTsecurity.PlayerRegistrationDto;
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
