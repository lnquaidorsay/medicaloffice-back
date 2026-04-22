package fr.train.ln.medioffice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocteurDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String specialite;
    private String telephone;
    private String email;
    private List<Long> rendezVousIds;
    private List<Long> prescriptionsIds;
}
