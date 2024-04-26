package com.example.productmanagement.Repository;

import com.example.productmanagement.Entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    // Recherche les produits par nom
    Page<Product> findByNomContaining(String recherche, org.springframework.data.domain.Pageable pageable);

     // Recherche les produits par fournisseur
    Page<Product> findByFournisseurContaining(String recherche, org.springframework.data.domain.Pageable pageable);

   }
