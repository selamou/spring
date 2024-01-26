package com.formation.formation.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LigneFactureEntity implements Serializable {
    @EmbeddedId
    private LigneFactureKey id;

    @ManyToOne
    @MapsId("factureId")
    @JoinColumn(name = "facture_id")
    private FactureEntity facture;
    @ManyToOne
    @MapsId("produitID")

    @JoinColumn(name = "produit_id")
    private ProduitEntity produit;
    @Column
    private Double quantie;
}
