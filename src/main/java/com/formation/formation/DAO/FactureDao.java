package com.formation.formation.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.formation.models.FactureEntity;
@Repository
public interface FactureDao extends JpaRepository<FactureEntity, Integer > {

}
