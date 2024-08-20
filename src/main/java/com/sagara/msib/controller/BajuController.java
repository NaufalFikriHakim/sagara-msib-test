package com.sagara.msib.controller;

import com.sagara.msib.dto.CreateUpdateBajuRequest;
import com.sagara.msib.model.Baju;
import com.sagara.msib.service.BajuService;
import lombok.RequiredArgsConstructor;
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
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/update/{id}") // use patch instead of put, so it can update specific value
    public ResponseEntity<Baju> updateBaju(@PathVariable Long id, @RequestBody CreateUpdateBajuRequest request){
        Baju response = service.updateBaju(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBaju(@PathVariable Long id){
        service.deleteBaju(id);
        return ResponseEntity.ok().body("Berhasil");
    }

    @PatchMapping("/stok/{id}")  // use patch to update specific value(stok)
    public ResponseEntity<Baju> updateStok(@PathVariable Long id, @RequestParam Integer jumlah){ // use request param
        Baju response = service.updateStokBaju(id, jumlah);
        return ResponseEntity.ok(response);
    }

}
