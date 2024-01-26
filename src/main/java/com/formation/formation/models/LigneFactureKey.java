package com.formation.formation.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class LigneFactureKey implements Serializable{
    
    @Column(name = "facture_id")
    private Integer factureId;
    @Column(name = "produit_id")
    private Integer produitID;



}
