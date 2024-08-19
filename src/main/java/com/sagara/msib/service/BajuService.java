package com.sagara.msib.service;

import com.sagara.msib.dto.CreateBajuRequest;
import com.sagara.msib.model.Baju;
import org.springframework.stereotype.Service;

@Service
public interface BajuService {
    public Baju createBaju(CreateBajuRequest request);
}
