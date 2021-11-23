// package com.example.springarchitecture.service;

// import com.example.springarchitecture.entity.Product;
// import com.example.springarchitecture.repository.ProductRepository;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.util.List;
// import java.util.stream.Collectors;

// import javassist.NotFoundException;

// @Service
// public class ProductService {
//     @Autowired
//     private ProductRepository repository;

//     public Product create(Product p) {
//         // ! 範例1.
//         // Product product = new Product();
//         // product.setName(p.getName());
//         // product.setPrice(p.getPrice());
//         // return repository.save(product);

//         // ! 範例2. 直接存取
//         return repository.save(p);
//     }

//     public Product getProduct(String id) throws Exception {
//         // get a specific product.
//         return repository.findById(id)
//             .orElseThrow(() -> new NotFoundException("cannot find product."));
//     }

//     public List<Product> getProducts() {
//         // get a list of product.
//         return repository.findAll();
//     }

//     public List<Product> searchLikeName(String name) {
//         // System.out.println("name: " + name);
//         // return repository.findByNameLike(name)
//         //     .stream()
//         //     .collect(Collectors.toList());
//         return repository.findByNameLike(name);
//     }
// }
