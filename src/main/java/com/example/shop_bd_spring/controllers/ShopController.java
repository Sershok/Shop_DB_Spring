package com.example.shop_bd_spring.controllers;
import com.example.shop_bd_spring.dtos.ShopDto;
import com.example.shop_bd_spring.models.Shop;
import com.example.shop_bd_spring.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping("/add_product_'{name}'_{productId}")
    public void addProductsShop(@PathVariable List<Long> productId, @PathVariable String name) {
        shopService.AddProduct(name, productId);
    }

    @PostMapping("/create")
    public Long createShop(@RequestBody ShopDto shopDto) {
        Shop shop = new Shop();
        shop.setName(shopDto.getName());
        shopService.createShop(shop);
        return shop.getId();
    }

    @DeleteMapping("/delete_{id}")
    public void deleteById(@PathVariable Long id) {
        shopService.deleteById(id);
    }

    @GetMapping("/get")
    public List<ShopDto> getProduct() {
        return shopService.getAll();
    }

}
