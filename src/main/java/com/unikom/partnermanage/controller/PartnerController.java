package com.unikom.partnermanage.controller;

import com.unikom.partnermanage.entity.PartnerEntity;
import com.unikom.partnermanage.service.impl.PartnerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Part;

@RestController
@RequestMapping("/partner")
public class PartnerController {

    private PartnerService partnerService;

//    Search by name, code...
    @GetMapping
    public ResponseEntity<?> search() {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return new ResponseEntity<>(partnerService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody PartnerEntity partnerEntity) {
        partnerService.save(partnerEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody PartnerEntity partnerEntity) {
        partnerEntity.setId(id);
        partnerService.save(partnerEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        partnerService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
