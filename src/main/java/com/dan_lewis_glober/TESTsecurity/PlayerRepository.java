package com.dan_lewis_glober.TESTsecurity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player findByEmail(String email);
}
