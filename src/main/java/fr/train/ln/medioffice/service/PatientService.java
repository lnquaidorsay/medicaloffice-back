package fr.train.ln.medioffice.service;

import fr.train.ln.medioffice.dto.PatientDTO;
import fr.train.ln.medioffice.entity.Patient;
import fr.train.ln.medioffice.exception.ResourceNotFoundException;
import fr.train.ln.medioffice.mapper.PatientMapper;
import fr.train.ln.medioffice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public Page<PatientDTO> getAllPatients(Pageable pageable) {
        return patientRepository.findAll(pageable)
                .map(PatientMapper::toDTO);
    }

    public PatientDTO getPatientById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient non trouvé avec l'id : " + id));
        return PatientMapper.toDTO(patient);
    }

    public PatientDTO createPatient(PatientDTO patientDTO) {
        Patient patient = PatientMapper.toEntity(patientDTO);
        Patient savedPatient = patientRepository.save(patient);
        return PatientMapper.toDTO(savedPatient);
    }

    public PatientDTO updatePatient(Long id, PatientDTO patientDTO) {
        Patient existingPatient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient non trouvé avec l'id : " + id));
        existingPatient.setNom(patientDTO.getNom());
        existingPatient.setPrenom(patientDTO.getPrenom());
        existingPatient.setDateNaissance(patientDTO.getDateNaissance());
        existingPatient.setAdresse(patientDTO.getAdresse());
        existingPatient.setTelephone(patientDTO.getTelephone());
        existingPatient.setEmail(patientDTO.getEmail());
        Patient updatedPatient = patientRepository.save(existingPatient);
        return PatientMapper.toDTO(updatedPatient);
    }

    public void deletePatient(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient non trouvé avec l'id : " + id));
        patientRepository.delete(patient);
    }
}
