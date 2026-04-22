package fr.train.ln.medioffice.repository;

import fr.train.ln.medioffice.entity.Receptionniste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReceptionnisteRepository extends JpaRepository<Receptionniste, Long> {
    Optional<Receptionniste> findByEmail(String email);
}
