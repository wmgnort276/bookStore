package com.example.demo.repository;

import com.example.demo.entity.AppUser;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)

public interface AppUserRepository extends BaseRepository{
    Optional<AppUser> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("update AppUser a set a.userEnabled = true where a.email = ?1")
    int enableAppUser(String email);
}
