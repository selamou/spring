
package com.formation.formation.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formation.formation.dto.FactureDto;
import com.formation.formation.dto.LigneFactureDto;
import com.formation.formation.models.ClientEntity;
import com.formation.formation.models.FactureEntity;
import com.formation.formation.models.LigneFactureEntity;
import com.formation.formation.models.ProduitEntity;
import com.formation.formation.service.facade.ClientService;
import com.formation.formation.service.facade.FactureService;
import com.formation.formation.service.facade.LigneFactureService;
import com.formation.formation.service.facade.ProduitService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("facture")
public class FactureController {
    @Autowired
    private FactureService factureService;
    @Autowired
    private LigneFactureService ligneFactureService;
    @Autowired
    private ProduitService produitService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private ModelMapper modelMapper;


    @PostMapping("")
    public ResponseEntity<FactureEntity> saveFacture(@RequestBody FactureDto factureDto) {


        FactureEntity facture = new FactureEntity();
        facture.setRef(factureDto.getRef());
        facture.setDate(new Date());
        ClientEntity clientEntity = modelMapper.map(clientService.findByNom(factureDto.getCin()), ClientEntity.class);
         facture.setClient(clientEntity);
        
        List<LigneFactureEntity> ligneFactures = factureDto.getLigneFactureDtos()
                .stream()
                .map(l -> convertToLigneFactureEntity(l) )
                .collect(Collectors.toList());
        
        facture.setFactureEntity(ligneFactures);
        
        System.out.println(facture);
        FactureEntity savedFacture = factureService.save(facture);
        return new ResponseEntity<>(savedFacture, HttpStatus.CREATED);
    }
    private LigneFactureEntity convertToLigneFactureEntity(LigneFactureDto ligneFactureDto) {


        LigneFactureEntity ligneFacture = new LigneFactureEntity();
        ProduitEntity produitEntity = modelMapper.map(produitService.findByRef(ligneFactureDto.getRefProfuit()),ProduitEntity.class);
      
        ligneFacture.setProduit(produitEntity);
        ligneFacture.setQuantie(ligneFactureDto.getQuantite());
        System.out.println("bn"+ligneFacture);
        LigneFactureEntity saved = ligneFactureService.save(ligneFacture);
        System.out.println("bhn"+saved);

        return saved;
    }

    @GetMapping("")
    public List<FactureEntity> getAll() {
        return factureService.findAll();
    }
    
}

