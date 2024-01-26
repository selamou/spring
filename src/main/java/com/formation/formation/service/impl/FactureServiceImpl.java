package com.formation.formation.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.formation.formation.DAO.FactureDao;
import com.formation.formation.models.FactureEntity;
import com.formation.formation.service.facade.FactureService;

import jakarta.transaction.Transactional;

@Service
public class FactureServiceImpl implements FactureService{
    private FactureDao factureDao;
    

    public FactureServiceImpl(FactureDao factureDao) {
        this.factureDao = factureDao;
    }

    @Override
    public List<FactureEntity> findAll() {
        return factureDao.findAll();
    }

    @Override
    @Transactional
    public FactureEntity save(FactureEntity factureEntity) {
        System.out.println("houun"+factureEntity);
        return factureDao.save(factureEntity);
    }

}
