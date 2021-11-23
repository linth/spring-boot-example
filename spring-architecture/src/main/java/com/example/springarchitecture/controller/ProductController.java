// package com.example.springarchitecture.controller;

// import java.util.List;

// import com.example.springarchitecture.entity.Product;
// import com.example.springarchitecture.repository.ProductRepository;
// import com.example.springarchitecture.service.ProductService;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.MediaType;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;


// /**
//  * 
//  * References:
//  *  - https://chikuwa-tech-study.blogspot.com/2021/07/spring-boot-mockito-unit-test.html
//  */
// @RestController
// @RequestMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
// public class ProductController {
//     @Autowired
//     private ProductService service;

//     @Autowired
//     private ProductRepository repository;

//     @GetMapping("")
//     public List<Product> getAllProduct() {
//         return repository.findAll();
//     }

//     @PostMapping("/create")
//     public ResponseEntity<?> create(@RequestBody Product product) {
//         try {            
//             return ResponseEntity.status(HttpStatus.OK)
//                 .body(service.create(product));
//         } catch (Exception e) {
//             return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                 .body("BAD_REQUEST " + e.toString());
//         }
//     }

//     // @GetMapping("/searchName")
//     // public List<Product> list(@RequestBody String name) {
//     //     System.out.println(name);
//     //     return service.searchLikeName(name);
//     // }
// }
