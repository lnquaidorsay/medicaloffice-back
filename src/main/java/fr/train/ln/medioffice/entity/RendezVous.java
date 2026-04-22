package fr.train.ln.medioffice.entity;

import fr.train.ln.medioffice.enums.StatutRendezVous;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Entity
@Table(name = "rendez_vous")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_heure", nullable = false)
    private OffsetDateTime dateHeure;

    @Column(nullable = false)
    private Integer duree;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatutRendezVous statut;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "docteur_id", nullable = false)
    private Docteur docteur;

    @ManyToOne
    @JoinColumn(name = "receptionniste_id", nullable = false)
    private Receptionniste receptionniste;
}
