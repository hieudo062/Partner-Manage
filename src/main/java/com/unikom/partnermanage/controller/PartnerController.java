package com.unikom.partnermanage.controller;

import com.unikom.partnermanage.dto.PartnerDTO;
import com.unikom.partnermanage.entity.Partner;
import com.unikom.partnermanage.service.impl.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partner")
@CrossOrigin(origins = "*")
public class PartnerController {

    @Autowired
    private PartnerService partnerService;

//    Search by name, code, foundedYear, quantityOfEmployee
    @GetMapping("/search")
    public ResponseEntity<List<PartnerDTO>> search(@RequestBody PartnerDTO partnerDTO) {
        return new ResponseEntity<>(partnerService.search(partnerDTO), HttpStatus.OK);
    }

    //    Search by name, code, foundedYear, quantityOfEmployee
    @GetMapping("/searchpage")
    public ResponseEntity<Page<PartnerDTO>> searchPage(@RequestBody PartnerDTO partnerDTO, @RequestBody Pageable pageable) {
        return new ResponseEntity<>(partnerService.searchPage(partnerDTO, pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return new ResponseEntity<>(partnerService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Partner partner) {
        partnerService.save(partner);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Partner partner) {
        partner.setId(id);
        partnerService.save(partner);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        partnerService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
