package fr.train.ln.medioffice.mapper;

import fr.train.ln.medioffice.dto.DocteurDTO;
import fr.train.ln.medioffice.entity.Docteur;
import fr.train.ln.medioffice.entity.RendezVous;
import fr.train.ln.medioffice.entity.Prescription;

import java.util.stream.Collectors;

public class DocteurMapper {
    public static DocteurDTO toDTO(Docteur docteur) {
        DocteurDTO dto = new DocteurDTO();
        dto.setId(docteur.getId());
        dto.setNom(docteur.getNom());
        dto.setPrenom(docteur.getPrenom());
        dto.setSpecialite(docteur.getSpecialite());
        dto.setTelephone(docteur.getTelephone());
        dto.setEmail(docteur.getEmail());
        if (docteur.getRendezVous() != null) {
            dto.setRendezVousIds(
                    docteur.getRendezVous()
                            .stream()
                            .map(RendezVous::getId)
                            .collect(Collectors.toList())
            );
        }
        if (docteur.getPrescriptions() != null) {
            dto.setPrescriptionsIds(
                    docteur.getPrescriptions()
                            .stream()
                            .map(Prescription::getId)
                            .collect(Collectors.toList())
            );
        }
        return dto;
    }

    public static Docteur toEntity(DocteurDTO dto) {
        Docteur docteur = new Docteur();
        docteur.setId(dto.getId());
        docteur.setNom(dto.getNom());
        docteur.setPrenom(dto.getPrenom());
        docteur.setSpecialite(dto.getSpecialite());
        docteur.setTelephone(dto.getTelephone());
        docteur.setEmail(dto.getEmail());
        // Les relations seront gérées dans le service
        return docteur;
    }
}
