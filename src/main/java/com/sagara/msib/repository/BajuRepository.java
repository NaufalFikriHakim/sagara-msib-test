package com.sagara.msib.repository;

import com.sagara.msib.model.Baju;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BajuRepository extends JpaRepository<Baju, Long> {

}
