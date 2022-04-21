package com.dan_lewis_glober.service;


import com.dan_lewis_glober.model.Player;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PlayerServiceImplTest {

    @Autowired
    private PlayerService playerService;

    @Test
    @Transactional
    void getAllPlayers() {

        List<Player> allPlayers = playerService.getAllPlayers();
        int beforeAddingPlayer = allPlayers.size()+1;

        Player player = new Player();
        player.setFirstName("Test");
        player.setUsername("TestUser");
        player.setEmail("test@gmail.com");
        player.setPassword("password");

        playerService.savePlayer(player);
        int afterAddingPlayer = playerService.getAllPlayers().size();

        Assertions.assertThat(afterAddingPlayer).isEqualTo(beforeAddingPlayer);
        Assertions.assertThat(allPlayers.contains(player));
    }
}
