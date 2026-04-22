package fr.train.ln.medioffice.mapper;

import fr.train.ln.medioffice.dto.DossierMedicalDTO;
import fr.train.ln.medioffice.entity.DossierMedical;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PrescriptionMapperMapStruct.class})
public interface DossierMedicalMapperMapStruct {
    @Mapping(source = "patient.id", target = "patientId")
    DossierMedicalDTO toDTO(DossierMedical dossierMedical);
    List<DossierMedicalDTO> toDTOs(List<DossierMedical> dossiersMedicaux);
    DossierMedical toEntity(DossierMedicalDTO dto);
}
