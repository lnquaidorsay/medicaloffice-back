package fr.train.ln.medioffice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Entity
@Table(name = "prescription")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_prescription", nullable = false)
    private OffsetDateTime datePrescription;

    @Column(nullable = false, length = 500)
    private String medicaments;

    @Column(nullable = false, length = 500)
    private String posologie;

    @ManyToOne
    @JoinColumn(name = "dossier_medical_id", nullable = false)
    private DossierMedical dossierMedical;

    @ManyToOne
    @JoinColumn(name = "docteur_id", nullable = false)
    private Docteur docteur;
}
