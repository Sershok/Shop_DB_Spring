package com.example.shop_bd_spring.dtos;

import com.example.shop_bd_spring.models.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {

    private String firstName;
    private String lastName;
    private String email;
    private List<Product> product;
    private BigDecimal sum;
}
