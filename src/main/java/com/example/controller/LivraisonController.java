package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Livraison;
import com.example.services.LivraisonService;

@RestController
@RequestMapping("/livraisons")
public class LivraisonController {

    private final LivraisonService livraisonService;

    @Autowired
    public LivraisonController(LivraisonService livraisonService) {
        this.livraisonService = livraisonService;
    }

    // Créer une nouvelle livraison
    @PostMapping
    public Livraison creerLivraison(@RequestBody Livraison livraison) {
        return livraisonService.creerLivraison(livraison);
    }

    // Obtenir toutes les livraisons
    @GetMapping
    public List<Livraison> obtenirToutesLesLivraisons() {
        return livraisonService.obtenirToutesLesLivraisons();
    }

    // Récupérer une livraison par son ID
    @GetMapping("/{id}")
    public Livraison obtenirLivraisonParId(@PathVariable int id) {
        return livraisonService.obtenirLivraisonParId(id);
    }

    // Mettre à jour une livraison
    @PutMapping("/{id}")
    public Livraison mettreAJourLivraison(@PathVariable int id, @RequestBody Livraison livraison) {
        return livraisonService.mettreAJourLivraison(id, livraison);
    }

    // Supprimer une livraison
    @DeleteMapping("/{id}")
    public boolean supprimerLivraison(@PathVariable int id) {
        return livraisonService.supprimerLivraison(id);
    }
}