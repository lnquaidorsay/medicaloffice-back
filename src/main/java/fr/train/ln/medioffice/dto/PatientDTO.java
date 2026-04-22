package fr.train.ln.medioffice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {
    private Long id;
    private String nom;
    private String prenom;
    private OffsetDateTime dateNaissance;
    private String adresse;
    private String telephone;
    private String email;
}
