package com.example.productmanagement.Controller;

import com.example.productmanagement.Entities.Commande;
import com.example.productmanagement.Service.CommandeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/commande")
public class CommandeController {

    @Autowired
    private CommandeServiceImp commandeServiceImp;

    @PostMapping("/save")
    public Commande saveCommande(@RequestBody Commande commande){

        return  commandeServiceImp.create(commande);
    }

    @GetMapping("/all")
    public List<Commande> getallCommande(){

        return commandeServiceImp.findAll();
    }
    @GetMapping("/getone/{id}")
    public Commande getonecommande(@PathVariable int id) {

        return  commandeServiceImp.findById(id);
    }
    @PutMapping("/update/{id}")
    public Commande updatecommande(@PathVariable int id, @RequestBody Commande commande){
        Commande c1=commandeServiceImp.findById(id);
        if(c1!=null){
            commande.setId(id);
            return commandeServiceImp.update(commande);
        }
        else {
            throw  new RuntimeException("Failed!!!");
        }
    }
    @DeleteMapping("/delete/{id}")
    public HashMap<String,String> deletecommande(@PathVariable int id){
        HashMap<String,String> message=new HashMap<>();
        if (commandeServiceImp.findById(id)==null){
            message.put("etat","modele not found");
            return  message;
        }
        try {
            commandeServiceImp.delete(id);
            message.put("etat","modele delete");
            return message;
        }catch (Exception e){
            message.put("etat","modele not deleted");
            return message;
        }
    }
}
