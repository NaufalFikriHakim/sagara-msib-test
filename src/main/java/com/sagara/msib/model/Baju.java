package com.sagara.msib.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Baju {
    @Id
    @GeneratedValue
    private Long id;

    private String warna;

    private String ukuran;

    private Integer harga;

    private Integer stok;
}
