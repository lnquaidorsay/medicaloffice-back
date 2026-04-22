package fr.train.ln.medioffice.service;

import fr.train.ln.medioffice.dto.DocteurDTO;
import fr.train.ln.medioffice.entity.Docteur;
import fr.train.ln.medioffice.exception.ResourceNotFoundException;
import fr.train.ln.medioffice.mapper.DocteurMapper;
import fr.train.ln.medioffice.repository.DocteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DocteurService {
    @Autowired
    private DocteurRepository docteurRepository;

    public Page<DocteurDTO> getAllDocteurs(Pageable pageable) {
        return docteurRepository.findAll(pageable)
                .map(DocteurMapper::toDTO);
    }

    public DocteurDTO getDocteurById(Long id) {
        Docteur docteur = docteurRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Médecin non trouvé avec l'id : " + id));
        return DocteurMapper.toDTO(docteur);
    }

    public DocteurDTO createDocteur(DocteurDTO docteurDTO) {
        Docteur docteur = DocteurMapper.toEntity(docteurDTO);
        Docteur savedDocteur = docteurRepository.save(docteur);
        return DocteurMapper.toDTO(savedDocteur);
    }

    public DocteurDTO updateDocteur(Long id, DocteurDTO docteurDTO) {
        Docteur existingDocteur = docteurRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Médecin non trouvé avec l'id : " + id));
        existingDocteur.setNom(docteurDTO.getNom());
        existingDocteur.setPrenom(docteurDTO.getPrenom());
        existingDocteur.setSpecialite(docteurDTO.getSpecialite());
        existingDocteur.setTelephone(docteurDTO.getTelephone());
        existingDocteur.setEmail(docteurDTO.getEmail());
        Docteur updatedDocteur = docteurRepository.save(existingDocteur);
        return DocteurMapper.toDTO(updatedDocteur);
    }

    public void deleteDocteur(Long id) {
        Docteur docteur = docteurRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Médecin non trouvé avec l'id : " + id));
        docteurRepository.delete(docteur);
    }
}