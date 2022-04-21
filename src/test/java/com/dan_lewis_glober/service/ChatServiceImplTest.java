package com.dan_lewis_glober.service;

import com.dan_lewis_glober.model.Chat;
import com.dan_lewis_glober.model.Location;
import com.dan_lewis_glober.model.Player;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ChatServiceImplTest {

    @Autowired
    private ChatService chatService;

    @Test
    @Transactional
    void getAllChats() {

        List<Chat> allChats = chatService.getAllChatMessages();
        int beforeAddingLocation = allChats.size();

        Assertions.assertThat(beforeAddingLocation).isEqualTo(0);

        Chat chat = new Chat();
        Player player = new Player();
        player.setUsername("TestUsername");
        player.setId(1);
        chat.setMessage("This is a test chat message.");

        chatService.saveChat(chat);
        int afterAddingLocation = chatService.getAllChatMessages().size();

        Assertions.assertThat(afterAddingLocation).isEqualTo(beforeAddingLocation + 1);
        Assertions.assertThat(allChats.contains(chat));
    }
}
