package com.gameserver.Dao;

import com.gameserver.Entitiy.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.math.BigDecimal;

@Repository
@Transactional
public interface PlayerDao extends JpaRepository<Player, Long> {

    Player getFirstByUsernameAndPassword(String username, String password);
    Player getFirstByUsername(String username);

    @Modifying
    @Query(value = "update player set wallet_balance = ?2 where username = ?1", nativeQuery = true)
    int updatePlayerProfile(String playerUsername, BigDecimal amount);
}
