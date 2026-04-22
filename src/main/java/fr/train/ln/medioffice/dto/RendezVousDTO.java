package fr.train.ln.medioffice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RendezVousDTO {
    private Long id;
    private OffsetDateTime dateHeure;
    private Integer duree;
    private String statut;
    private Long patientId;
    private Long docteurId;
    private Long receptionnisteId;
}
