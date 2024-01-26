package com.formation.formation.service.facade;

import java.util.List;

import com.formation.formation.models.LigneFactureEntity;

public interface LigneFactureService {
    LigneFactureEntity save(LigneFactureEntity ligneFactureEntity);
    List <LigneFactureEntity> findAll();

}
