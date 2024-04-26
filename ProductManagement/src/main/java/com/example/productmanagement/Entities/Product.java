package com.example.productmanagement.Entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "PRODUCTS")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    // Identifiant généré automatiquement
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Nom du produit
    private String nom;

    // Prix du produit
    private double prix;

    // Devise du prix (ex: EUR, USD, etc.)
    @Column(length = 3)
    private String devise;

    // Taxe appliquée au produit (en pourcentage)
    private Integer taxe;

    // Date d'expiration du produit
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateExpiration;

    // Nom du fournisseur du produit
    private String fournisseur;

    // Nom de l'image du produit
    private String image;

    // Fichier image du produit (transient car non stocké en base de données)
    @Transient
    private MultipartFile imageFile;

    @ManyToMany(mappedBy = "products")
    private Set<Commande> commandes;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public Integer getTaxe() {
        return taxe;
    }

    public void setTaxe(Integer taxe) {
        this.taxe = taxe;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public String getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(String fournisseur) {
        this.fournisseur = fournisseur;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public MultipartFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }

    public Set<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(Set<Commande> commandes) {
        this.commandes = commandes;
    }


}
