package com.example.demo.repository;

import com.example.demo.entity.ConfirmationToken;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface ConfirmationRepository extends BaseRepository<ConfirmationToken,Integer>{
    Optional<ConfirmationToken> findByToken(String token);
    @Transactional
    @Modifying
    @Query(value = "update ConfirmationToken c SET c.confirmAt = ?2 where c.token = ?1")
    int updateConfirmAt(String token, LocalDateTime confirmAt);
}
