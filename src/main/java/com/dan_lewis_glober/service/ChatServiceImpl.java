package com.dan_lewis_glober.service;

import com.dan_lewis_glober.model.Chat;
import com.dan_lewis_glober.model.Player;
import com.dan_lewis_glober.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService{

    @Autowired
    private ChatRepository chatRepository;

    @Override
    public List<Chat> getAllChatMessages() {
        return chatRepository.findAll();
    }

    @Override
    public void saveChat(Chat chat) {this.chatRepository.save(chat);}

    @Override
    public List<Chat> findChatByPlayerId(Long id) {
        return chatRepository.findPlayerById(id);
    }
}
