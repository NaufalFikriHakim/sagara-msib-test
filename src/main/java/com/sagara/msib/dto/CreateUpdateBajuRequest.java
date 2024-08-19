package com.sagara.msib.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUpdateBajuRequest {
    private String warna;
    private String ukuran;
    private Integer harga;
    private Integer stok;
}
