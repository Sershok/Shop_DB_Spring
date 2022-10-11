package com.example.shop_bd_spring.dtos;

import com.example.shop_bd_spring.models.Cart;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {

    private String firstName;
    private String lastName;
    private String email;
    private Cart cart;
}
