package com.dan_lewis_glober.service;

import com.dan_lewis_glober.model.Chat;

import java.util.List;

public interface ChatService {
    List<Chat> getAllChatMessages();
    void saveChat(Chat chat);
    List<Chat> findChatByPlayerId(Long id);
}
