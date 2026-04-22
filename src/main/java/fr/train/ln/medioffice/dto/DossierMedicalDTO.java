package fr.train.ln.medioffice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DossierMedicalDTO {
    private Long id;
    private OffsetDateTime dateCreation;
    private String antecedents;
    private String allergies;
    private Long patientId;
    private List<PrescriptionDTO> prescriptions;
}
