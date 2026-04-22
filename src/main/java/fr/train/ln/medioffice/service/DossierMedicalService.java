package fr.train.ln.medioffice.service;

import fr.train.ln.medioffice.dto.DossierMedicalDTO;
import fr.train.ln.medioffice.entity.DossierMedical;
import fr.train.ln.medioffice.entity.Patient;
import fr.train.ln.medioffice.exception.ResourceNotFoundException;
import fr.train.ln.medioffice.mapper.DossierMedicalMapper;
import fr.train.ln.medioffice.repository.DossierMedicalRepository;
import fr.train.ln.medioffice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DossierMedicalService {
    @Autowired
    private DossierMedicalRepository dossierMedicalRepository;
    @Autowired
    private PatientRepository patientRepository;

    public Page<DossierMedicalDTO> getAllDossiersMedicaux(Pageable pageable) {
        return dossierMedicalRepository.findAll(pageable)
                .map(DossierMedicalMapper::toDTO);
    }

    public DossierMedicalDTO getDossierMedicalById(Long id) {
        DossierMedical dossierMedical = dossierMedicalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dossier médical non trouvé avec l'id : " + id));
        return DossierMedicalMapper.toDTO(dossierMedical);
    }

    public DossierMedicalDTO createDossierMedical(DossierMedicalDTO dossierMedicalDTO) {
        Patient patient = patientRepository.findById(dossierMedicalDTO.getPatientId())
                .orElseThrow(() -> new ResourceNotFoundException("Patient non trouvé avec l'id : " + dossierMedicalDTO.getPatientId()));

        DossierMedical dossierMedical = DossierMedicalMapper.toEntity(dossierMedicalDTO);
        dossierMedical.setPatient(patient);

        DossierMedical savedDossierMedical = dossierMedicalRepository.save(dossierMedical);
        return DossierMedicalMapper.toDTO(savedDossierMedical);
    }

    public DossierMedicalDTO updateDossierMedical(Long id, DossierMedicalDTO dossierMedicalDTO) {
        DossierMedical existingDossierMedical = dossierMedicalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dossier médical non trouvé avec l'id : " + id));

        Patient patient = patientRepository.findById(dossierMedicalDTO.getPatientId())
                .orElseThrow(() -> new ResourceNotFoundException("Patient non trouvé avec l'id : " + dossierMedicalDTO.getPatientId()));

        existingDossierMedical.setDateCreation(dossierMedicalDTO.getDateCreation());
        existingDossierMedical.setAntecedents(dossierMedicalDTO.getAntecedents());
        existingDossierMedical.setAllergies(dossierMedicalDTO.getAllergies());
        existingDossierMedical.setPatient(patient);

        DossierMedical updatedDossierMedical = dossierMedicalRepository.save(existingDossierMedical);
        return DossierMedicalMapper.toDTO(updatedDossierMedical);
    }

    public void deleteDossierMedical(Long id) {
        DossierMedical dossierMedical = dossierMedicalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dossier médical non trouvé avec l'id : " + id));
        dossierMedicalRepository.delete(dossierMedical);
    }
}
