package com.formation.formation.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.formation.models.LigneFactureEntity;
import com.formation.formation.models.LigneFactureKey;
@Repository
public interface LigneFactureDao extends JpaRepository<LigneFactureEntity,LigneFactureKey > {

}
