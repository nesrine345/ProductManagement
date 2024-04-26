package com.example.productmanagement.Service;

import com.example.productmanagement.Entities.Product;
import com.example.productmanagement.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService
    {
        @Autowired

        private  ProductRepository produitRepository;



        @Override
        public Product create(Product product)
        {
            return produitRepository.save(product);
        }

        @Override
        public List<Product> findAll()
        {
            return produitRepository.findAll();
        }

        @Override
        public Product update( Product product)
        {
            return produitRepository.saveAndFlush(product);
        }

        @Override
        public String delete(Integer id)
        {
            produitRepository.deleteById(id);
            return "Produit supprimé";
        }


        public Product findById(Integer id)
        {
            return produitRepository.findById(id).orElse(null);
        }

        @Override
        public Page<Product> lireProduitsPagine(int page, int pageSize, String sortBy)
        {

            if (pageSize <= 0)
            {
                throw new IllegalArgumentException("La taille de la page doit être supérieure à zéro");
            }
            Sort.Direction directionTri = Sort.Direction.ASC; // Par défaut, tri ascendant
            String proprieteTri = sortBy; // Par défaut, tri par l'id
            if (sortBy != null)
            {
                if (sortBy.startsWith("-"))
                {
                    directionTri = Sort.Direction.DESC;
                    proprieteTri = sortBy.substring(1); // Retirer le préfixe "-"
                }
                else
                {
                    proprieteTri = sortBy;
                }
            }
            else
            {
                proprieteTri = "id";
            }
            PageRequest pageRequest = PageRequest.of(page, pageSize, directionTri, proprieteTri);
            try {
                return produitRepository.findAll(pageRequest);
            } catch (Exception e) {
                throw new RuntimeException("Erreur lors de la récupération des produits paginés", e);
            }
        }


        public Page<Product> search(String search, String critere) {
        org.springframework.data.domain.Pageable pageable = PageRequest.of(0,Integer.MAX_VALUE); // ou autre pagination
        switch (critere) {
            case "nom":
                return produitRepository.findByNomContaining(search, pageable);
            case "fournisseur":
                return produitRepository.findByFournisseurContaining(search, pageable);
            default:
                throw new IllegalArgumentException("Critère de recherche non valide: " + critere);
        }
    }
}
