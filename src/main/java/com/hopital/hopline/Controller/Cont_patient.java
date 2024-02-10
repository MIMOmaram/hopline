package com.hopital.hopline.Controller;

import com.hopital.hopline.Model.Modeldocteur;
import com.hopital.hopline.Service.patient_service;
import com.hopital.hopline.Model.Modelpatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/patients")
public class Cont_patient {

    @Autowired
    private patient_service patientService;

    @GetMapping("/afficher")
    public String afficherTousPatients(Model model) {
        List<Modelpatient> patients = patientService.afficherpatients();
        model.addAttribute("patients", patients);
        return "interface_patient/afficherPatients";
    }

    @GetMapping("/afficher/{id}")
    public String afficherPatientParId(@PathVariable Long id, Model model) {
        Optional<Modelpatient> patient = patientService.afficherpatient(id);
        model.addAttribute("patient", patient.orElse(null));
        return "afficherPatient"; // Nom de la page HTML pour afficher un patient
    }

    @GetMapping("/ajouter_patient")
    public String afficherFormulaireAjoutPatient(Model model) {
        Modelpatient patient =new Modelpatient();
        model.addAttribute("patient", patient);
        return "interface_patient/formulaireAjoutPatient";
    }
    @PostMapping("/ajouter")
    public String ajouterPatient(@ModelAttribute Modelpatient patient) {
        patientService.ajouterpatient(patient);
        return "redirect:/patients/afficher";
    }


    @GetMapping("/modifier_patient/{id}")
    public String afficherFormulaireModifierPatient(@PathVariable Long id, Model model) {
        Optional<Modelpatient> patient = patientService.afficherpatient(id);
        model.addAttribute("patient", patient.orElse(null));
        return "interface_patient/formulaireModifierPatient";
    }

    @PostMapping("/modifier/{id}")
    public String modifierPatient(@PathVariable Long id, @ModelAttribute Modelpatient patient) {
        patientService.modifierpatient( patient);
        return "redirect:/patients/afficher";
    }


    @GetMapping("/supprimer_patient/{id}")
    public String afficherFormulaireSuppression(@PathVariable Long id, Model model) {
        Optional<Modelpatient> patient= patientService.afficherpatient(id);
        model.addAttribute("patient", patient.orElse(null));
        return "interface_patient/supprimer_patient";
    }

    @PostMapping("/supprimer")
    public String supprimerpatient(@RequestParam("id") Long id) {
        patientService.supprimerpatient(id);
        return "redirect:/patients/afficher";
    }

}