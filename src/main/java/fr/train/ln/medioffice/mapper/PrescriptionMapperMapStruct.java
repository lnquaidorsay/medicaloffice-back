package fr.train.ln.medioffice.mapper;

import fr.train.ln.medioffice.dto.PrescriptionDTO;
import fr.train.ln.medioffice.entity.Prescription;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PrescriptionMapperMapStruct {
    @Mapping(source = "dossierMedical.id", target = "dossierMedicalId")
    @Mapping(source = "docteur.id", target = "docteurId")
    PrescriptionDTO toDTO(Prescription prescription);
    List<PrescriptionDTO> toDTOs(List<Prescription> prescriptions);
    Prescription toEntity(PrescriptionDTO dto);
}
