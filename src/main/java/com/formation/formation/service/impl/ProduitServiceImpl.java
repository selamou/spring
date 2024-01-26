package com.formation.formation.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.formation.formation.DAO.ProduitDao;
import com.formation.formation.dto.ProduitDto;
import com.formation.formation.exception.EntityAlreadyExistsException;
import com.formation.formation.exception.EntityNotFoundException;
import com.formation.formation.models.ProduitEntity;
import com.formation.formation.service.facade.ProduitService;

import jakarta.transaction.Transactional;

@Service
public class ProduitServiceImpl implements ProduitService {
    private ProduitDao produitDao;
    private ModelMapper modelMapper;

    public ProduitServiceImpl(ProduitDao produitDao, ModelMapper modelMapper) {
        this.produitDao = produitDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProduitDto findByRef(String ref) {
        Optional<ProduitEntity> produitEntity = produitDao.findByRef(ref);
        if (produitEntity == null)
            return null;
        return modelMapper.map(produitEntity, ProduitDto.class);
    }

    @Override
    public List<ProduitDto> findall() {
          return produitDao.findAll().stream().map(
            el -> 
        modelMapper.map(el, ProduitDto.class ))
        .collect(Collectors.toList())
        ;
    }

    @Override
    public ProduitDto save(ProduitDto produitDto) {
        System.out.println("bbbb");
        if (findByRef(produitDto.getRef()) != null)
        throw new  EntityAlreadyExistsException("Produit deja exist");
        
        ProduitEntity produitEntity = modelMapper.map(produitDto, ProduitEntity.class);
        System.out.println(produitEntity);
        ProduitEntity saved = produitDao.save(produitEntity);

        return modelMapper.map(saved, ProduitDto.class);
    }

    @Override
    public ProduitDto update(ProduitDto produitDto) {
        Optional<ProduitEntity> produitEntityOptional = produitDao.findByRef(produitDto.getRef());
        if (produitEntityOptional.isEmpty()) throw new  EntityNotFoundException("Product not found");
        produitEntityOptional.get().setLibelle(produitDto.getLibelle());
        produitEntityOptional.get().setPrix(produitDto.getPrix());
        produitEntityOptional.get().setQuantite_stock(produitDto.getQuantite_stock());
        ProduitEntity saved = produitDao.save(produitEntityOptional.get());
        return modelMapper.map(saved, ProduitDto.class);
    }

  
    @Override
    @Transactional
    public int delete(String ref) {
        return produitDao.deleteByRef(ref);
       
    }

}
