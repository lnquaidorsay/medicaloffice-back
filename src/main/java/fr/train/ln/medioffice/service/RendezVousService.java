package fr.train.ln.medioffice.service;

import fr.train.ln.medioffice.dto.RendezVousDTO;
import fr.train.ln.medioffice.entity.Docteur;
import fr.train.ln.medioffice.entity.Patient;
import fr.train.ln.medioffice.entity.Receptionniste;
import fr.train.ln.medioffice.entity.RendezVous;
import fr.train.ln.medioffice.enums.StatutRendezVous;
import fr.train.ln.medioffice.exception.ResourceNotFoundException;
import fr.train.ln.medioffice.mapper.RendezVousMapper;
import fr.train.ln.medioffice.repository.DocteurRepository;
import fr.train.ln.medioffice.repository.PatientRepository;
import fr.train.ln.medioffice.repository.ReceptionnisteRepository;
import fr.train.ln.medioffice.repository.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RendezVousService {
    @Autowired
    private RendezVousRepository rendezVousRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DocteurRepository docteurRepository;
    @Autowired
    private ReceptionnisteRepository receptionnisteRepository;

    public Page<RendezVousDTO> getAllRendezVous(Pageable pageable) {
        return rendezVousRepository.findAll(pageable)
                .map(RendezVousMapper::toDTO);
    }

    public RendezVousDTO getRendezVousById(Long id) {
        RendezVous rendezVous = rendezVousRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rendez-vous non trouvé avec l'id : " + id));
        return RendezVousMapper.toDTO(rendezVous);
    }

    public RendezVousDTO createRendezVous(RendezVousDTO rendezVousDTO) {
        Patient patient = patientRepository.findById(rendezVousDTO.getPatientId())
                .orElseThrow(() -> new ResourceNotFoundException("Patient non trouvé avec l'id : " + rendezVousDTO.getPatientId()));
        Docteur docteur = docteurRepository.findById(rendezVousDTO.getDocteurId())
                .orElseThrow(() -> new ResourceNotFoundException("Médecin non trouvé avec l'id : " + rendezVousDTO.getDocteurId()));
        Receptionniste receptionniste = receptionnisteRepository.findById(rendezVousDTO.getReceptionnisteId())
                .orElseThrow(() -> new ResourceNotFoundException("Réceptionniste non trouvé avec l'id : " + rendezVousDTO.getReceptionnisteId()));

        RendezVous rendezVous = RendezVousMapper.toEntity(rendezVousDTO);
        rendezVous.setPatient(patient);
        rendezVous.setDocteur(docteur);
        rendezVous.setReceptionniste(receptionniste);

        RendezVous savedRendezVous = rendezVousRepository.save(rendezVous);
        return RendezVousMapper.toDTO(savedRendezVous);
    }

    public RendezVousDTO updateRendezVous(Long id, RendezVousDTO rendezVousDTO) {
        RendezVous existingRendezVous = rendezVousRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rendez-vous non trouvé avec l'id : " + id));

        Patient patient = patientRepository.findById(rendezVousDTO.getPatientId())
                .orElseThrow(() -> new ResourceNotFoundException("Patient non trouvé avec l'id : " + rendezVousDTO.getPatientId()));
        Docteur docteur = docteurRepository.findById(rendezVousDTO.getDocteurId())
                .orElseThrow(() -> new ResourceNotFoundException("Médecin non trouvé avec l'id : " + rendezVousDTO.getDocteurId()));
        Receptionniste receptionniste = receptionnisteRepository.findById(rendezVousDTO.getReceptionnisteId())
                .orElseThrow(() -> new ResourceNotFoundException("Réceptionniste non trouvé avec l'id : " + rendezVousDTO.getReceptionnisteId()));

        existingRendezVous.setDateHeure(rendezVousDTO.getDateHeure());
        existingRendezVous.setDuree(rendezVousDTO.getDuree());
        existingRendezVous.setStatut(StatutRendezVous.valueOf(rendezVousDTO.getStatut()));
        existingRendezVous.setPatient(patient);
        existingRendezVous.setDocteur(docteur);
        existingRendezVous.setReceptionniste(receptionniste);

        RendezVous updatedRendezVous = rendezVousRepository.save(existingRendezVous);
        return RendezVousMapper.toDTO(updatedRendezVous);
    }

    public void deleteRendezVous(Long id) {
        RendezVous rendezVous = rendezVousRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rendez-vous non trouvé avec l'id : " + id));
        rendezVousRepository.delete(rendezVous);
    }
}
