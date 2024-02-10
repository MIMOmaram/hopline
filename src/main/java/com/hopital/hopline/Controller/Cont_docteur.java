package com.hopital.hopline.Controller;

import com.hopital.hopline.Model.Modelpatient;
import com.hopital.hopline.Service.docteur_service;
import com.hopital.hopline.Model.Modeldocteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/docteurs")
public class Cont_docteur {

    @Autowired
    private docteur_service docteurService;

    @GetMapping("/afficher")
    public String afficherTousDocteurs(Model model) {
        List<Modeldocteur> docteurs = docteurService.afficherdocteurs();
        model.addAttribute("docteurs", docteurs);
        model.addAttribute("docteur", new Modeldocteur());
        return "interface_docteur/afficherDocteurs";
    }

    @GetMapping("/afficher/{id}")
    public String afficherDocteurParId(@PathVariable Long id, Model model) {
        Optional<Modeldocteur> docteur = docteurService.afficherdocteur(id);
        model.addAttribute("docteur", docteur.orElse(null));
        return "";
    }

    @GetMapping("/ajouter_docteur")
    public String afficherFormulaireAjoutDocteur(Model model) {
        Modeldocteur docteur =new Modeldocteur();

        model.addAttribute("docteur",docteur );
        return "interface_docteur/formulaireAjoutDocteur";
    }

    @PostMapping("/ajouter")
    public String ajouterDocteur(@ModelAttribute Modeldocteur docteur) {
        docteurService.ajouterdocteur(docteur);
        return "redirect:/docteurs/afficher";
    }

    @GetMapping("/modifier_docteur/{id}")
    public String afficherFormulaireModifierDocteur(@PathVariable Long id, Model model) {
        Optional<Modeldocteur> docteur = docteurService.afficherdocteur(id);
        model.addAttribute("docteur", docteur.orElse(null));
        return "interface_docteur/formulaireModifierDocteur";
    }

    @PostMapping("/modifier/{id}")
    public String modifierDocteur(@PathVariable Long id, @ModelAttribute Modeldocteur docteur) {
        docteurService.modifierdocteur(docteur);
        return "redirect:/docteurs/afficher";
    }
    @GetMapping("/supprimer_docteur/{id}")
    public String afficherFormulaireSuppression(@PathVariable Long id, Model model) {
        Optional<Modeldocteur> docteur = docteurService.afficherdocteur(id);
        model.addAttribute("docteur", docteur.orElse(null));
        return "interface_docteur/supprimer_docteur";
    }

    @PostMapping("/supprimer")
    public String supprimerDocteur(@RequestParam("id") Long id) {
        docteurService.supprimerdocteur(id);
        return "redirect:/docteurs/afficher";
    }



}


