package fr.train.ln.medioffice.repository;

import fr.train.ln.medioffice.entity.Docteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DocteurRepository extends JpaRepository<Docteur, Long> {
    Optional<Docteur> findByEmail(String email);
}
