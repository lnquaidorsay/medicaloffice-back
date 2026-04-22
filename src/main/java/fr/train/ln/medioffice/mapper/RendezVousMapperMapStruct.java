package fr.train.ln.medioffice.mapper;

import fr.train.ln.medioffice.dto.RendezVousDTO;
import fr.train.ln.medioffice.entity.RendezVous;
import fr.train.ln.medioffice.enums.StatutRendezVous;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RendezVousMapperMapStruct {
    @Mapping(source = "patient.id", target = "patientId")
    @Mapping(source = "docteur.id", target = "docteurId")
    @Mapping(source = "receptionniste.id", target = "receptionnisteId")
    @Mapping(source = "statut", target = "statut", qualifiedByName = "statutToString")
    RendezVousDTO toDTO(RendezVous rendezVous);
    List<RendezVousDTO> toDTOs(List<RendezVous> rendezVous);
    RendezVous toEntity(RendezVousDTO dto);

    @Named("statutToString")
    default String statutToString(StatutRendezVous statut) {
        return statut.name();
    }
}
