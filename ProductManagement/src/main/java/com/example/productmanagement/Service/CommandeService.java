package com.example.productmanagement.Service;

import com.example.productmanagement.Entities.Commande;


import java.util.List;

public interface CommandeService {
    /**
     * Crée un nouveau produit.
     *
     * @param commande le produit à créer
     * @return le produit créé
     */
    Commande create(Commande commande);


    /**
     * Récupère la liste de tous les produits.
     *
     * @return la liste des produits
     */
    List<Commande> findAll();


    /**
     * Modifie un produit existant.
     *
     * @param commande les nouvelles informations du produit
     * @return le produit modifié
     */
    Commande update(Commande commande);


    /**
     * Supprime un produit existant.
     *
     * @param id l'identifiant du produit à supprimer
     * @return un message indiquant si la suppression a été effectuée avec succès
     */
    String delete(int id);


    /**
     * Trouve un produit par son identifiant.
     *
     * @param id l'identifiant du produit à trouver
     * @return le produit correspondant à l'identifiant
     */
    Commande findById(int id);



}
