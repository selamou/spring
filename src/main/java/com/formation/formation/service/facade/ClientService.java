package com.formation.formation.service.facade;

import java.util.List;

import com.formation.formation.dto.ClientRequestDto;
import com.formation.formation.dto.ClientResponseDto;

public interface ClientService {

    ClientResponseDto save(ClientRequestDto ClientRequestDto);
    ClientResponseDto findById( Integer id);
    ClientResponseDto findByNom( String nnom); 
    void delete( Integer id);
    ClientResponseDto update(ClientRequestDto ClientRequestDto , Integer id);
    List<ClientResponseDto> findall();

}
