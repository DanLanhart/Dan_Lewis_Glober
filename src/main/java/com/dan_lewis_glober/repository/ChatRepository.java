package com.dan_lewis_glober.repository;

import com.dan_lewis_glober.model.Chat;
import com.dan_lewis_glober.model.Player;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Long> {
    List<Chat> findPlayerById(Long id);
}
