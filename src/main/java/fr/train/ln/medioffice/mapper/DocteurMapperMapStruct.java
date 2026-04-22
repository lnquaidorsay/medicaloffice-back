package fr.train.ln.medioffice.mapper;

import fr.train.ln.medioffice.dto.DocteurDTO;
import fr.train.ln.medioffice.entity.Docteur;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DocteurMapperMapStruct {
    @Mapping(target = "rendezVousIds", expression = "java(mapRendezVousIds(docteur))")
    @Mapping(target = "prescriptionsIds", expression = "java(mapPrescriptionsIds(docteur))")
    DocteurDTO toDTO(Docteur docteur);
    List<DocteurDTO> toDTOs(List<Docteur> docteurs);
    Docteur toEntity(DocteurDTO dto);

    default List<Long> mapRendezVousIds(Docteur docteur) {
        return docteur.getRendezVous()
                .stream()
                .map(rv -> rv.getId())
                .toList();
    }

    default List<Long> mapPrescriptionsIds(Docteur docteur) {
        return docteur.getPrescriptions()
                .stream()
                .map(p -> p.getId())
                .toList();
    }
}
