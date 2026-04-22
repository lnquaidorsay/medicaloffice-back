package fr.train.ln.medioffice.mapper;

import fr.train.ln.medioffice.dto.ReceptionnisteDTO;
import fr.train.ln.medioffice.entity.Receptionniste;
import fr.train.ln.medioffice.entity.RendezVous;

import java.util.stream.Collectors;

public class ReceptionnisteMapper {
    public static ReceptionnisteDTO toDTO(Receptionniste receptionniste) {
        ReceptionnisteDTO dto = new ReceptionnisteDTO();
        dto.setId(receptionniste.getId());
        dto.setNom(receptionniste.getNom());
        dto.setPrenom(receptionniste.getPrenom());
        dto.setTelephone(receptionniste.getTelephone());
        dto.setEmail(receptionniste.getEmail());
        if (receptionniste.getRendezVous() != null) {
            dto.setRendezVousIds(
                    receptionniste.getRendezVous()
                            .stream()
                            .map(RendezVous::getId)
                            .collect(Collectors.toList())
            );
        }
        return dto;
    }

    public static Receptionniste toEntity(ReceptionnisteDTO dto) {
        Receptionniste receptionniste = new Receptionniste();
        receptionniste.setId(dto.getId());
        receptionniste.setNom(dto.getNom());
        receptionniste.setPrenom(dto.getPrenom());
        receptionniste.setTelephone(dto.getTelephone());
        receptionniste.setEmail(dto.getEmail());
        // Les relations seront gérées dans le service
        return receptionniste;
    }
}
