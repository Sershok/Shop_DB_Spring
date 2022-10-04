//package com.example.shop_bd_spring.services;
//
//import com.example.shop_bd_spring.models.Cart;
//import com.example.shop_bd_spring.models.Person;
//import com.example.shop_bd_spring.models.Product;
//import com.example.shop_bd_spring.models.Shop;
//import com.example.shop_bd_spring.repositorys.PersonRepository;
//import com.example.shop_bd_spring.repositorys.ProductRepository;
//import com.example.shop_bd_spring.repositorys.ShopRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class ShopServiceImpl implements ShopService {
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    @Autowired
//    private ShopRepository shopRepository;
//
//
//    @Override
//    public String createShop(Shop shop,List<Long> productId) {
////        Shop newShop = new Shop();
////
////        newShop.setShopName(shop.getShopName());
////        List<Product> products = getProducts(productId);
////        newShop.setProduct(products);
////        return shopRepository.save(newShop).getShopName();
//        return null;
//    }
//
//    private List<Product> getProducts(List<Long> productId) {
//        return productId.stream().map(productRepository::getOne).collect(Collectors.toList());
//    }
//}
