package com.example.productmanagement.Service;

import com.example.productmanagement.Entities.Commande;
import com.example.productmanagement.Repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeServiceImp implements CommandeService{
    @Autowired

    private CommandeRepository commandeRepository;
    @Override
    public Commande create(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public List<Commande> findAll() {
        return commandeRepository.findAll();
    }

    @Override
    public Commande update(Commande commande) {
        return commandeRepository.saveAndFlush(commande);
    }

    @Override
    public String delete(int id) {
        commandeRepository.deleteById((long) id);
        return "Commande supprimé";
    }

    @Override
    public Commande findById(int id) {
        return commandeRepository.findById((long) id).orElse(null);
    }
}
