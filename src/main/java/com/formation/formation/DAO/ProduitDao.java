package com.formation.formation.DAO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.formation.models.ProduitEntity;
@Repository
public interface ProduitDao extends JpaRepository<ProduitEntity,Integer>{
    Optional<ProduitEntity> findByRef(String ref);
    Optional<ProduitEntity> findByLibelle(String libelle);

    List<ProduitEntity> findByPrixGreaterThan(BigDecimal prix );

    int deleteByRef(String ref);


}
