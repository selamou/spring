package com.formation.formation.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequestDto {
    @NotNull(message = "le nom est obligatoire ....!")
    @Size(min = 5,max = 20,message = "le nombre de charactere doit etre entre 5 et 20")
    @NotBlank
    private String nom;
    @NotNull(message = "le prenom est obligatoire ....!")
    @Size(min = 5,max = 20,message = "le nombre de charactere doit etre entre 5 et 20")
    private String prenom;
    @NotNull(message = "le numero du telephone est obligatoire ....!")
    @Size(min = 8,max = 8,message = "le nombre de charactere doit etre 8")
    private String telephone;

}
