package fr.train.ln.medioffice.mapper;

import fr.train.ln.medioffice.dto.PrescriptionDTO;
import fr.train.ln.medioffice.entity.Prescription;

public class PrescriptionMapper {
    public static PrescriptionDTO toDTO(Prescription prescription) {
        PrescriptionDTO dto = new PrescriptionDTO();
        dto.setId(prescription.getId());
        dto.setDatePrescription(prescription.getDatePrescription());
        dto.setMedicaments(prescription.getMedicaments());
        dto.setPosologie(prescription.getPosologie());
        dto.setDossierMedicalId(prescription.getDossierMedical().getId());
        dto.setDocteurId(prescription.getDocteur().getId());
        return dto;
    }

    public static Prescription toEntity(PrescriptionDTO dto) {
        Prescription prescription = new Prescription();
        prescription.setId(dto.getId());
        prescription.setDatePrescription(dto.getDatePrescription());
        prescription.setMedicaments(dto.getMedicaments());
        prescription.setPosologie(dto.getPosologie());
        // Les relations seront gérées dans le service
        return prescription;
    }
}
