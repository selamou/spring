package com.formation.formation.dto;

import java.math.BigDecimal;

import lombok.Data;
@Data
public class ProduitDto {
    private int id;
    private String ref;
    private String libelle;
     private BigDecimal prix;
      private Double quantite_stock;


}
