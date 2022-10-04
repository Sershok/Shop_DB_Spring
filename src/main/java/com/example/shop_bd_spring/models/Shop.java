//package com.example.shop_bd_spring.models;
//
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name = "shop")
//public class Shop {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String shopName;
//    @OneToMany
//    @JoinColumn(name = "product_id")
//    private List<Product> product = new ArrayList<>();
//
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "person_id")
//    private Person person;
//
//}
