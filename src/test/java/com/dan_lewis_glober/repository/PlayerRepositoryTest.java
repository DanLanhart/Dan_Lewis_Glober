package com.dan_lewis_glober.repository;

import com.dan_lewis_glober.model.Player;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PlayerRepositoryTest {

    @Autowired
    private PlayerRepository playerRepository;

    @Test
    void findPlayerByEmail_should_return_Player_given_valid_email() {

        // The data.sql file must be executed before running this test in order to populate the player model
        Player testPlayer = playerRepository.findByEmail("test@gmail.com");
        Assertions.assertThat(testPlayer.getEmail()).isEqualTo("test@gmail.com");

    }
}
