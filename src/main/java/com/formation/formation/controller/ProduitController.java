package com.formation.formation.controller;

import org.springframework.web.bind.annotation.RestController;

import com.formation.formation.dto.ProduitDto;
import com.formation.formation.service.facade.ProduitService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;






@RestController
@RequestMapping("produit")
@RequiredArgsConstructor
public class ProduitController {
    
    @Autowired
    private ProduitService produitService;

    @PostMapping("")
    public ResponseEntity<ProduitDto> save(@RequestBody ProduitDto produitDto){
        return new ResponseEntity<>(produitService.save(produitDto),HttpStatus.CREATED);
    }

    @GetMapping("/ref/{ref}")
    public ResponseEntity <ProduitDto> findByRef(@PathVariable String ref) {
        return ResponseEntity.ok(  produitService.findByRef(ref));
    }
    @DeleteMapping("/ref/{ref}")
    public ResponseEntity<?> deleteByRef(@PathVariable String ref) {
        return ResponseEntity.accepted().body(produitService.delete(ref));
    }

    @PutMapping("")
    public ResponseEntity<ProduitDto> update(@RequestBody ProduitDto produitDto) {
        return ResponseEntity.accepted().body(produitService.update(produitDto)); 
    }

    @GetMapping("")
    public ResponseEntity<List<ProduitDto> >findall() {
        return new ResponseEntity<>( produitService.findall(),HttpStatus.OK);
    }
    
}
