package com.formation.formation.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formation.formation.dto.ClientRequestDto;
import com.formation.formation.dto.ClientResponseDto;
import com.formation.formation.service.facade.ClientService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("clients")
public class ClientController {

    @Autowired
    private ClientService clientservice;

    @GetMapping("")
    public ResponseEntity<List<ClientResponseDto >>  getClients( ){
        //  return clientservice.findall();
        return new ResponseEntity<>( clientservice.findall(), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<ClientResponseDto>  save(@Valid @RequestBody() ClientRequestDto clientRequestDto){

    //  return clientservice.save(clientRequestDto); 
    return new ResponseEntity<>(clientservice.save(clientRequestDto),HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ClientResponseDto> findById(@PathVariable("id") Integer id) {
        // return clientservice.findById(id);
        return ResponseEntity.ok(clientservice.findById(id));

    }
    @GetMapping("/nom/{nom}")
    public ResponseEntity<ClientResponseDto>  findByNom(@PathVariable() String nom) {
        // return clientservice.findByNom(nom);
        return ResponseEntity.ok(clientservice.findByNom(nom));

    }
    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> delete( @PathVariable() Integer id){
        clientservice.delete(id);
        return ResponseEntity.noContent().build();
    } 

    @PutMapping("id/{id}")
    public ResponseEntity<ClientResponseDto> update(@PathVariable Integer id,@Valid @RequestBody ClientRequestDto clientRequestDto) {
       
        return  ResponseEntity.accepted().body(clientservice.update(clientRequestDto, id));
    }
    
    


}
