package fr.train.ln.medioffice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionDTO {
    private Long id;
    private OffsetDateTime datePrescription;
    private String medicaments;
    private String posologie;
    private Long dossierMedicalId;
    private Long docteurId;
}
