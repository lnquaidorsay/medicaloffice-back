package fr.train.ln.medioffice.mapper;

import fr.train.ln.medioffice.dto.DossierMedicalDTO;
import fr.train.ln.medioffice.entity.DossierMedical;

import java.util.stream.Collectors;

public class DossierMedicalMapper {
    public static DossierMedicalDTO toDTO(DossierMedical dossierMedical) {
        DossierMedicalDTO dto = new DossierMedicalDTO();
        dto.setId(dossierMedical.getId());
        dto.setDateCreation(dossierMedical.getDateCreation());
        dto.setAntecedents(dossierMedical.getAntecedents());
        dto.setAllergies(dossierMedical.getAllergies());
        dto.setPatientId(dossierMedical.getPatient().getId());
        if (dossierMedical.getPrescriptions() != null) {
            dto.setPrescriptions(
                    dossierMedical.getPrescriptions()
                            .stream()
                            .map(PrescriptionMapper::toDTO)
                            .collect(Collectors.toList())
            );
        }
        return dto;
    }

    public static DossierMedical toEntity(DossierMedicalDTO dto) {
        DossierMedical dossierMedical = new DossierMedical();
        dossierMedical.setId(dto.getId());
        dossierMedical.setDateCreation(dto.getDateCreation());
        dossierMedical.setAntecedents(dto.getAntecedents());
        dossierMedical.setAllergies(dto.getAllergies());
        // La relation avec Patient et Prescriptions sera gérée dans le service
        return dossierMedical;
    }
}
