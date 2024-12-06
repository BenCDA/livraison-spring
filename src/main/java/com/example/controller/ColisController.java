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

import com.example.model.Colis;
import com.example.services.ColisService;
import com.example.wrappers.ColisWrapper;

@RestController
@RequestMapping("/colis")
public class ColisController {

    @Autowired
    private ColisService colisService;

    // Récupérer tous les colis
    @GetMapping("/tous")
    public ColisWrapper getAllColis() {
        List<Colis> colisList = colisService.getAllColis();
        ColisWrapper colisWrapper = new ColisWrapper();
        colisWrapper.setColisList(colisList);
        return colisWrapper;
    }

    // Récupérer un colis par son ID
    @GetMapping("/{id}")
    public Colis getColisById(@PathVariable int id) {
        return colisService.getColisById(id);
    }

    // Créer un colis
    @PostMapping("/creer")
    public Colis createColis(@RequestBody Colis colis) {
        return colisService.createColis(colis);
    }

    // Mettre à jour un colis
    @PutMapping("/mettre-a-jour/{id}")
    public Colis updateColis(@PathVariable int id, @RequestBody Colis colis) {
        return colisService.updateColis(id, colis);
    }

    // Supprimer un colis
    @DeleteMapping("/supprimer/{id}")
    public boolean  deleteColis(@PathVariable int id) {
        return colisService.deleteColis(id);
    }
}