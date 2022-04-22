package com.unikom.partnermanage.controller;

import com.unikom.partnermanage.dto.PartnerDTO;
import com.unikom.partnermanage.dto.Search;
import com.unikom.partnermanage.service.impl.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.OptionalInt;

@RestController
@RequestMapping("/partner")
@CrossOrigin(origins = "*")
public class PartnerController {

    @Autowired
    private PartnerService partnerService;

    @GetMapping("/search")
    public ResponseEntity<Page<PartnerDTO>> search(@RequestParam(required = false) String code,
                                                   @RequestParam(required = false) String name,
                                                   @RequestParam(required = false) Integer foundedYear,
                                                   @RequestParam(required = false) Integer quantityOfEmployee,
                                                   Pageable pageable) {
        Search search = new Search();
        search.setCode(code);
        search.setName(name);
        Integer foundedYearInt = foundedYear == null ? 0 : foundedYear;
        search.setFoundedYear(foundedYearInt);
        Integer quantityOfEmployeeInt = quantityOfEmployee == null ? 0 : quantityOfEmployee;
        search.setQuantityOfEmployee(quantityOfEmployeeInt);

        return new ResponseEntity<>(partnerService.search(search, pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return new ResponseEntity<>(partnerService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody PartnerDTO partner) {
        partnerService.save(partner);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody PartnerDTO partner) {
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
