package fr.train.ln.medioffice.mapper;

import fr.train.ln.medioffice.dto.PatientDTO;
import fr.train.ln.medioffice.entity.Patient;

public class PatientMapper {
    public static PatientDTO toDTO(Patient patient) {
        PatientDTO dto = new PatientDTO();
        dto.setId(patient.getId());
        dto.setNom(patient.getNom());
        dto.setPrenom(patient.getPrenom());
        dto.setDateNaissance(patient.getDateNaissance());
        dto.setAdresse(patient.getAdresse());
        dto.setTelephone(patient.getTelephone());
        dto.setEmail(patient.getEmail());
        return dto;
    }

    public static Patient toEntity(PatientDTO dto) {
        Patient patient = new Patient();
        patient.setId(dto.getId());
        patient.setNom(dto.getNom());
        patient.setPrenom(dto.getPrenom());
        patient.setDateNaissance(dto.getDateNaissance());
        patient.setAdresse(dto.getAdresse());
        patient.setTelephone(dto.getTelephone());
        patient.setEmail(dto.getEmail());
        return patient;
    }
}
