package com.formation.formation.service.facade;

import java.util.List;

import com.formation.formation.models.FactureEntity;

public interface FactureService {
    FactureEntity save(FactureEntity factureEntity);
    List<FactureEntity> findAll();

}
