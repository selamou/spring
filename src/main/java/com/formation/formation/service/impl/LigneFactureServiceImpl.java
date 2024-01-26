package com.formation.formation.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.formation.formation.DAO.LigneFactureDao;
import com.formation.formation.models.LigneFactureEntity;
import com.formation.formation.service.facade.LigneFactureService;

import jakarta.transaction.Transactional;


@Service
public class LigneFactureServiceImpl implements LigneFactureService {
    private LigneFactureDao ligneFactureDao;

    public LigneFactureServiceImpl(LigneFactureDao ligneFactureDao) {
        this.ligneFactureDao = ligneFactureDao;
    }

    @Override
    public List<LigneFactureEntity> findAll() {
        return ligneFactureDao.findAll();
    }

    @Override
    @Transactional
    public LigneFactureEntity save(LigneFactureEntity ligneFactureEntity) {
        return ligneFactureDao.save(ligneFactureEntity);
    }

}
