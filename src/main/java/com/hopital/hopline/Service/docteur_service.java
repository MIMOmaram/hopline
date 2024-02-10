package com.hopital.hopline.Service;

import com.hopital.hopline.Repository.docteur_repo;
import org.springframework.beans.factory.annotation.Autowired;
import com.hopital.hopline.Model.Modeldocteur;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // Add this import

@Service
public class docteur_service {
    @Autowired
    private docteur_repo docteurRepository;

    public List<Modeldocteur> afficherdocteurs() {
        return docteurRepository.findAll();
    }
    public Optional<Modeldocteur> afficherdocteur(Long id) {
        return docteurRepository.findById(id);
    }

    public void ajouterdocteur(Modeldocteur docteur) {
        docteurRepository.save(docteur);
    }

    @Transactional
    public void modifierdocteur(Modeldocteur docteur) {

        if (docteur.getId_doc() != null) {
            Optional<Modeldocteur> existingDocteur = docteurRepository.findById(docteur.getId_doc());

            if (existingDocteur.isPresent()) {
                Modeldocteur updatedDocteur = existingDocteur.get();
                updatedDocteur.setNom_doc(docteur.getNom_doc());
                updatedDocteur.setPrenom_doc(docteur.getPrenom_doc());
                updatedDocteur.setSpecialite(docteur.getSpecialite());
                updatedDocteur.setConseil(docteur.getConseil());

                docteurRepository.save(updatedDocteur);
            }
        }
    }


    public void supprimerdocteur(Long id) {
        Optional<Modeldocteur> docteurOptional = docteurRepository.findById(id);
        if (docteurOptional.isPresent()) {
            docteurRepository.deleteById(id);
        } else {
        }
    }
}



