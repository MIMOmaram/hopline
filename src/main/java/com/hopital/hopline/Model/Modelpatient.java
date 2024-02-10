package com.hopital.hopline.Model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="patient") //nom dela table
public class Modelpatient {
    @Id//cle primaire
    @GeneratedValue(strategy = GenerationType.AUTO) //auto increment
    @Column(name = "id")
    private Long id_pat;
    @Column(name = "cin")
    private String cin;
    @Column(name = "nom_pat")
    private String nom_pat;
    @Column(name = "prenom_pat")
    private String prenom_pat;
    @Column(name = "age")
    private Long age;
    @Column(name = "poids")
    private Double poids;
    @Column(name = "description")
    private String description;

}
