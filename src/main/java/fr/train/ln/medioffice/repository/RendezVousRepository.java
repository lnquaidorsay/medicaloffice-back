package fr.train.ln.medioffice.repository;

import fr.train.ln.medioffice.entity.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {
    List<RendezVous> findByDocteurId(Long docteurId);
    List<RendezVous> findByPatientId(Long patientId);

}
