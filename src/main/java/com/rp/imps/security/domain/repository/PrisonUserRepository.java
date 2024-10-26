package com.rp.imps.security.domain.repository;

import com.rp.imps.security.domain.PrisonUser;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PrisonUserRepository extends JpaRepository<PrisonUser, String> {
    Optional<PrisonUser> findByUsername(String username);
}
