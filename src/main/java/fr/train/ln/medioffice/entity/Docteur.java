package fr.train.ln.medioffice.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "docteur")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Docteur {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, length = 50)
        private String nom;

        @Column(nullable = false, length = 50)
        private String prenom;

        @Column(nullable = false, length = 100)
        private String specialite;

        @Column(nullable = false, length = 20)
        private String telephone;

        @Column(nullable = false, length = 100, unique = true)
        private String email;

        @OneToMany(mappedBy = "docteur", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private List<RendezVous> rendezVous = new ArrayList<>();

        @OneToMany(mappedBy = "docteur", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private List<Prescription> prescriptions = new ArrayList<>();
}
