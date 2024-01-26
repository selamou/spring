package com.formation.formation.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.formation.models.ClientEntity;

@Repository
public interface ClientDao extends JpaRepository<ClientEntity,Integer>{

    ClientEntity findByNom(String nom);

}
