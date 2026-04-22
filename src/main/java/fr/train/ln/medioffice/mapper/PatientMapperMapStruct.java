package fr.train.ln.medioffice.mapper;

import fr.train.ln.medioffice.dto.PatientDTO;
import fr.train.ln.medioffice.entity.Patient;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientMapperMapStruct {
    PatientDTO toDTO(Patient patient);
    Patient toEntity(PatientDTO patientDTO);
    List<PatientDTO> toDTOs(List<Patient> patients);
    List<Patient> toEntities(List<PatientDTO> patientDTOs);
}
