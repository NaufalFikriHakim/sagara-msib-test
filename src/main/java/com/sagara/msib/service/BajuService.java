package com.sagara.msib.service;

import com.sagara.msib.dto.CreateUpdateBajuRequest;
import com.sagara.msib.model.Baju;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BajuService {
    public Baju createBaju(CreateUpdateBajuRequest request);

    public List<Baju> getAllBaju();

    public Baju getBajuById(Long id);

    public Baju updateBaju(Long id, CreateUpdateBajuRequest request);

    public void deleteBaju(Long id);
}
