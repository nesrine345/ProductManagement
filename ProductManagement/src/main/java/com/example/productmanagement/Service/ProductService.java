package com.example.productmanagement.Service;

import com.example.productmanagement.Entities.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    /**
     * Crée un nouveau produit.
     *
     * @param product le produit à créer
     * @return le produit créé
     */
    Product create(Product product);


    /**
     * Récupère la liste de tous les produits.
     *
     * @return la liste des produits
     */
    List<Product> findAll();


    /**
     * Modifie un produit existant.
     *
     * @param produit les nouvelles informations du produit
     * @return le produit modifié
     */
    Product update(Product produit);


    /**
     * Supprime un produit existant.
     *
     * @param id l'identifiant du produit à supprimer
     * @return un message indiquant si la suppression a été effectuée avec succès
     */
    String delete(Integer id);


    /**
     * Trouve un produit par son identifiant.
     *
     * @param id l'identifiant du produit à trouver
     * @return le produit correspondant à l'identifiant
     */
    Product findById(Integer id);


    Page<Product> lireProduitsPagine(int page, int pageSize, String sortBy) ;


    public Page<Product> search(String search, String critere);
}
