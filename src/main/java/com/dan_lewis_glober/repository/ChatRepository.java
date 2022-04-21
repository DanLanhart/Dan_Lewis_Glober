package com.dan_lewis_glober.repository;

import com.dan_lewis_glober.model.Chat;
import com.dan_lewis_glober.model.Player;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
    List<Chat> findPlayerById(Long id);
}
