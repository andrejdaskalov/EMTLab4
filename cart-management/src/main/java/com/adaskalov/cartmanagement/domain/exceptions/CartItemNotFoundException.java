package com.adaskalov.cartmanagement.domain.exceptions;

public class CartItemNotFoundException extends Exception{
    public CartItemNotFoundException(){
        super("Cart Item Not Found");
    }
}
