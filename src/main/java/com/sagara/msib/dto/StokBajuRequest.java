package com.sagara.msib.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StokBajuRequest {
    private Integer stok; // stok bisa positif dan negatif
}
