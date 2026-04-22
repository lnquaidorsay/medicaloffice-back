package fr.train.ln.medioffice.mapper;

import fr.train.ln.medioffice.dto.ReceptionnisteDTO;
import fr.train.ln.medioffice.entity.Receptionniste;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReceptionnisteMapperMapStruct {
    @Mapping(target = "rendezVousIds", expression = "java(mapRendezVousIds(receptionniste))")
    ReceptionnisteDTO toDTO(Receptionniste receptionniste);
    List<ReceptionnisteDTO> toDTOs(List<Receptionniste> receptionnistes);
    Receptionniste toEntity(ReceptionnisteDTO dto);

    default List<Long> mapRendezVousIds(Receptionniste receptionniste) {
        return receptionniste.getRendezVous()
                .stream()
                .map(rv -> rv.getId())
                .toList();
    }
}