package com.formation.formation.service.impl;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.formation.formation.DAO.ClientDao;
import com.formation.formation.dto.ClientRequestDto;
import com.formation.formation.dto.ClientResponseDto;
import com.formation.formation.exception.EntityNotFoundException;
import com.formation.formation.models.ClientEntity;
import com.formation.formation.service.facade.ClientService;


@Service
public class ClientServiceImpl implements ClientService{
    private ClientDao clientDao;
    private ModelMapper modelMapper;

    public ClientServiceImpl(ClientDao clientDao, ModelMapper modelMapper) {
        this.clientDao = clientDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public void delete(Integer id) {
         clientDao.deleteById(id);
        
    }

    @Override
    public ClientResponseDto findById(Integer id) {
        ClientEntity clientEntity = clientDao.findById(id).orElseThrow(()-> new EntityNotFoundException ("client not found"));
        return modelMapper.map(clientEntity,ClientResponseDto.class);
    }

    @Override
    public ClientResponseDto findByNom(String nom) {
        ClientEntity clientEntity = clientDao.findByNom(nom);
        return modelMapper.map(clientEntity,ClientResponseDto.class);
    }

    @Override
    public ClientResponseDto save(ClientRequestDto ClientRequestDto) {
        ClientEntity clientEntity = modelMapper.map(ClientRequestDto,ClientEntity.class );
        System.out.println(clientEntity);
        ClientEntity saved = clientDao.save(clientEntity );
        return modelMapper.map(saved,ClientResponseDto.class);
    }

    @Override
    public ClientResponseDto update(ClientRequestDto ClientRequestDto, Integer id) {
       Optional<ClientEntity> clientEntityOptional = clientDao.findById(id);
       if (clientEntityOptional.isPresent()){

        ClientEntity clientEntity = modelMapper.map(ClientRequestDto,ClientEntity.class );
        clientEntity.setId(id); 
        ClientEntity updated= clientDao.save(clientEntity);
        return modelMapper.map(updated, ClientResponseDto.class);
       }
       else {
        throw new  EntityNotFoundException("client not found");
       }
    }

    @Override
    public List<ClientResponseDto> findall() {
        return clientDao.findAll().stream().map(
            el -> 
        modelMapper.map(el, ClientResponseDto.class ))
        .collect(Collectors.toList())
        ;
    }
     

}
