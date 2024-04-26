package com.example.productmanagement.Controller;

import com.example.productmanagement.Entities.Product;
import com.example.productmanagement.Service.ProductService;
import com.example.productmanagement.Service.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServiceImp productService;
    @PostMapping("/createProduct")
// Elle retourne une ResponseEntity, qui est un objet qui représente toute la réponse HTTP, y compris le corps, les en-têtes et le statut.
    public ResponseEntity<Product> createClient(@RequestBody Product product) {
        try {
            productService.create(product);
            return new ResponseEntity<Product>(product, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/listProduct")
    public ResponseEntity<List<Product>> getAllProducts(){
        try {
            List<Product> clients = productService.findAll();

            if(clients.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(clients, HttpStatus.OK);

        }
        catch (Exception e) {
            return new ResponseEntity<List<Product>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getClientById(@PathVariable("id") int id) {
        Product product = productService.findById(id);

        if (product != null) {
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/updateProduct/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product){
        Product c1=productService.findById(id);
        if(c1!=null){
            product.setId(id);
            return productService.update(product);
        }
        else {
            throw  new RuntimeException("Failed!!!");
        }
    }
    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<HttpStatus> deleteClient2(@PathVariable("id") int id) {
        try {
            productService.delete(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
