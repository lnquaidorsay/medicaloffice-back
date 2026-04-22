package fr.train.ln.medioffice.mapper;

import fr.train.ln.medioffice.dto.RendezVousDTO;
import fr.train.ln.medioffice.entity.RendezVous;
import fr.train.ln.medioffice.enums.StatutRendezVous;

public class RendezVousMapper {
    public static RendezVousDTO toDTO(RendezVous rendezVous) {
        RendezVousDTO dto = new RendezVousDTO();
        dto.setId(rendezVous.getId());
        dto.setDateHeure(rendezVous.getDateHeure());
        dto.setDuree(rendezVous.getDuree());
        dto.setStatut(rendezVous.getStatut().name());
        dto.setPatientId(rendezVous.getPatient().getId());
        dto.setDocteurId(rendezVous.getDocteur().getId());
        dto.setReceptionnisteId(rendezVous.getReceptionniste().getId());
        return dto;
    }

    public static RendezVous toEntity(RendezVousDTO dto) {
        RendezVous rendezVous = new RendezVous();
        rendezVous.setId(dto.getId());
        rendezVous.setDateHeure(dto.getDateHeure());
        rendezVous.setDuree(dto.getDuree());
        rendezVous.setStatut(StatutRendezVous.valueOf(dto.getStatut()));
        // Les relations seront gérées dans le service
        return rendezVous;
    }
}
