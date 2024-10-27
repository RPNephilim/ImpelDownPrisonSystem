package com.rp.imps.model.repository;

import com.rp.imps.model.entity.Prisoner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrisonerRepository extends JpaRepository<Prisoner, String> {
}
