package com.sagara.msib.controller;

import com.sagara.msib.dto.CreateUpdateBajuRequest;
import com.sagara.msib.model.Baju;
import com.sagara.msib.service.BajuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/baju")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class BajuController {

    private final BajuService service;

    @PostMapping("/create")
    public ResponseEntity<Baju> createBaju(@RequestBody CreateUpdateBajuRequest request){
        Baju response = service.createBaju(request);
        if (response == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Baju>> getAllBaju(){
        List<Baju> response = service.getAllBaju();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Baju> getBajuById(@PathVariable Long id){
        Baju response = service.getBajuById(id);
        if (response == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/update/{id}") // use patch instead of put, so it can update specific value
    public ResponseEntity<Baju> updateBaju(@PathVariable Long id, @RequestBody CreateUpdateBajuRequest request){
        Baju response = service.updateBaju(id, request);
        if (response == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBaju(@PathVariable Long id){
        Boolean success = service.deleteBaju(id);
        if (!success) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body("Berhasil");
    }

    @PatchMapping("/stok/{id}")  // use patch to update specific value(stok)
    public ResponseEntity<Baju> updateStok(@PathVariable Long id, @RequestParam Integer jumlah){ // use request param
        Baju response = service.updateStokBaju(id, jumlah);
        if (response == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Baju>> search(@RequestParam(required = false) String warna, @RequestParam(required = false) String ukuran){
        List<Baju> response = service.search(warna, ukuran);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/habis")
    public ResponseEntity<List<Baju>> getHabis(){
        List<Baju> response = service.getStokHabis();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/kurang")
    public ResponseEntity<List<Baju>> getKurang(){
        List<Baju> response = service.getStokKurang();
        return ResponseEntity.ok(response);
    }

}
