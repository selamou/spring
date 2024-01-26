 package com.formation.formation.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;
@Data 
public class FactureDto {

    private String ref;
    private Date date;
    private String cin;
    List<LigneFactureDto> ligneFactureDtos; 

}
