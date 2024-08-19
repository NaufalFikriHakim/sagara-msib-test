package com.sagara.msib.controller;

import com.sagara.msib.dto.CreateBajuRequest;
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
    public ResponseEntity<Baju> createBaju(@RequestBody CreateBajuRequest request){
        Baju response = service.createBaju(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Baju>> getAllBaju(){
        List<Baju> response = service.getAllBaju();
        return ResponseEntity.ok(response);
    }

}
