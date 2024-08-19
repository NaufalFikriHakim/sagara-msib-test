package com.sagara.msib.repository;

import com.sagara.msib.model.Baju;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BajuRepository extends JpaRepository<Baju, Long> {

    List<Baju> findAll();

    Optional<Baju> findById(Long id);
}
