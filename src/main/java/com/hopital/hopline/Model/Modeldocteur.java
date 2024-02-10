package com.hopital.hopline.Model;

import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="docteur") //nom dela table
public class Modeldocteur {
    @Id//cle primaire
    @GeneratedValue(strategy = GenerationType.AUTO) //auto increment
    @Column(name = "id_doc")
    private Long id_doc;
    @Column(name = "specialite")
    private String specialite;
    @Column(name = "nom_doc")
    private String nom_doc;
    @Column(name = "prenom_doc")
    private String prenom_doc;
    @Column(name = "conseil")
    private String conseil;
}
