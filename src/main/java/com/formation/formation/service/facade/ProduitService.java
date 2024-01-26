package com.formation.formation.service.facade;

import java.util.List;

import com.formation.formation.dto.ProduitDto;

public interface ProduitService {
    ProduitDto save(ProduitDto produitDto);
    ProduitDto findByRef( String ref); 
    int delete( String ref);
    ProduitDto update(ProduitDto produitDto );
    List<ProduitDto> findall();

}
