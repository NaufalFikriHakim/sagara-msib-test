package com.sagara.msib.service;

import com.sagara.msib.dto.CreateBajuRequest;
import com.sagara.msib.model.Baju;
import com.sagara.msib.repository.BajuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BajuServiceImpl implements BajuService{

    @Autowired
    private final BajuRepository repository;

    @Override
    public Baju createBaju(CreateBajuRequest request) {
        return repository.save(Baju.builder()
                .warna(request.getWarna())
                .ukuran(request.getUkuran())
                .harga(request.getHarga())
                .stok(request.getStok())
                .build());
    }

    @Override
    public List<Baju> getAllBaju() {
        return repository.findAll();
    }

    @Override
    public Baju getBajuById(Long id) {
        //assuming the item is vali
        return repository.findById(id).get();
    }
}
