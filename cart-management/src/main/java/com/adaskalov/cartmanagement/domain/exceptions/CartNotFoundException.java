package com.adaskalov.cartmanagement.domain.exceptions;

public class CartNotFoundException extends Exception{
    public CartNotFoundException(){
        super("Cart Not Found");
    }

}
