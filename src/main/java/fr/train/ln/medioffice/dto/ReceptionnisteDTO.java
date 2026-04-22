package fr.train.ln.medioffice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReceptionnisteDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String telephone;
    private String email;
    private List<Long> rendezVousIds;
}
