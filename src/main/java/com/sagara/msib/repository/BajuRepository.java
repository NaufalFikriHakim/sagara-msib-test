package com.sagara.msib.repository;

import com.sagara.msib.model.Baju;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BajuRepository extends JpaRepository<Baju, Long> {

    List<Baju> findAll();

    Optional<Baju> findById(Long id);

    @Query(value = "SELECT * FROM BAJU WHERE warna = :warna", nativeQuery = true)
    List<Baju> findBajuByWarna(@Param("warna") String warna);

    @Query(value = "SELECT * FROM BAJU WHERE ukuran = :ukuran", nativeQuery = true)
    List<Baju> findBajuByUkuran(@Param("ukuran") String ukuran);

    @Query(value = "SELECT * FROM BAJU WHERE ukuran = :ukuran AND warna = :warna", nativeQuery = true)
    List<Baju> findBajuByWarnaAndUkuran(@Param("warna") String warna, @Param("ukuran") String ukuran);
}
