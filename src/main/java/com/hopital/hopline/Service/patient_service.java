package com.hopital.hopline.Service;

import com.hopital.hopline.Repository.patient_repo;
import com.hopital.hopline.Model.Modelpatient;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class patient_service {

    @Autowired
    private patient_repo patientRepository;

    public List<Modelpatient> afficherpatients() {
        return patientRepository.findAll();
    }

    public Optional<Modelpatient> afficherpatient(Long id) {
        return patientRepository.findById(id);
    }

    public void ajouterpatient(Modelpatient patient) {
        patientRepository.save(patient);
    }

    @Transactional
    public void modifierpatient(Modelpatient patient) {
        if (patient.getId_pat() != null) {
            Optional<Modelpatient> existingPatient = patientRepository.findById(patient.getId_pat());

            if (existingPatient.isPresent()) {
                Modelpatient updatedPatient = existingPatient.get();
                updatedPatient.setNom_pat(patient.getNom_pat());
                updatedPatient.setPrenom_pat(patient.getPrenom_pat());
                updatedPatient.setCin(patient.getCin());
                updatedPatient.setAge(patient.getAge());
                updatedPatient.setPoids(patient.getPoids());
                updatedPatient.setDescription((patient.getDescription()));

                patientRepository.save(updatedPatient);
            }
        }
    }

    public void supprimerpatient(Long id) {
        Optional<Modelpatient> patientOptional = patientRepository.findById(id);
        if (patientOptional.isPresent()) {
            patientRepository.deleteById(id);
        } else {
        }
    }
}



