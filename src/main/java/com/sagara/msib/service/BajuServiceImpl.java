package com.sagara.msib.service;

import com.sagara.msib.dto.CreateUpdateBajuRequest;
import com.sagara.msib.model.Baju;
import com.sagara.msib.repository.BajuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BajuServiceImpl implements BajuService{

    @Autowired
    private final BajuRepository repository;

    @Override
    public Baju createBaju(CreateUpdateBajuRequest request) {
        if (request.getHarga() <= 0 || request.getStok() <= 0)return null;
        return repository.save(Baju.builder()
                .warna(request.getWarna().toLowerCase())
                .ukuran(request.getUkuran().toLowerCase())
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
        Optional<Baju> response = repository.findById(id);
        return response.orElse(null);
    }

    @Override
    public Baju updateBaju(Long id, CreateUpdateBajuRequest request) {
        Optional<Baju> response = repository.findById(id);
        if (response.isEmpty()) return null;

        Baju baju = response.get();

        if (request.getHarga() != null) baju.setHarga(request.getHarga());
        if (request.getUkuran() != null) baju.setUkuran(request.getUkuran().toLowerCase());
        if (request.getStok() != null) baju.setStok(request.getStok());
        if (request.getWarna() != null) baju.setWarna(request.getWarna().toLowerCase());

        return repository.save(baju);
    }

    @Override
    public boolean deleteBaju(Long id) {
        Optional<Baju> response = repository.findById(id);
        if (response.isEmpty()) return false;
        repository.delete(response.get());
        return true;
    }

    @Override
    public Baju updateStokBaju(Long id, Integer jumlah) {
        //TODO: validate biar jumlah baju selalu lebih besar dari 0
        Optional<Baju> response = repository.findById(id);
        if (response.isEmpty())return null; // can be improved by throwing exception
        Baju baju = response.get();

        if (baju.getStok() + jumlah < 0) return null;

        baju.setStok(baju.getStok() + jumlah);

        return repository.save(baju);
    }

    @Override
    public List<Baju> search(String warna, String ukuran) {
        List<Baju> baju;
        if (warna != null && ukuran != null){
            baju = repository.findBajuByWarnaAndUkuran(warna, ukuran);
        } else if (warna != null) {
            baju = repository.findBajuByWarna(warna);
        } else if (ukuran != null) {
            baju = repository.findBajuByUkuran(ukuran);
        } else {
            baju = repository.findAll();
        }
        return baju;
    }

    @Override
    public List<Baju> getStokHabis() {
        return repository.findBajuByStokHabis();
    }

    @Override
    public List<Baju> getStokKurang() {
        return repository.findBajuByStokKurang();
    }
}
