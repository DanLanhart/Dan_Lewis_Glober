package com.dan_lewis_glober.repository;

import com.dan_lewis_glober.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {
}
