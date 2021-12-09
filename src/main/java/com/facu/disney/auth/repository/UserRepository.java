package com.facu.disney.auth.repository;

import com.facu.disney.auth.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
    
        UserEntity findByUsername(String username);
}
