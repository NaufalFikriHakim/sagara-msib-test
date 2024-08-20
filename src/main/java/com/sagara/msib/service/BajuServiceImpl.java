package com.sagara.msib.service;

import com.sagara.msib.dto.CreateUpdateBajuRequest;
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
    public Baju createBaju(CreateUpdateBajuRequest request) {
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
        //TODO: id is item valid
        return repository.findById(id).get();
    }

    @Override
    public Baju updateBaju(Long id, CreateUpdateBajuRequest request) {
        // TODO: validate id
        Baju baju = repository.findById(id).get();

        if (request.getHarga() != null) baju.setHarga(request.getHarga());
        if (request.getUkuran() != null) baju.setUkuran(request.getUkuran());
        if (request.getStok() != null) baju.setStok(request.getStok());
        if (request.getWarna() != null) baju.setWarna(request.getWarna());

        return repository.save(baju);
    }

    @Override
    public void deleteBaju(Long id) {
        //TODO: validate id
        Baju baju = repository.findById(id).get();
        repository.delete(baju);
    }

    @Override
    public Baju updateStokBaju(Long id, Integer jumlah) {
        //TODO: validate biar jumlah baju selalu lebih besar dari 0
        Baju baju = repository.findById(id).get();

        baju.setStok(baju.getStok() + jumlah);

        return repository.save(baju);
    }
}
