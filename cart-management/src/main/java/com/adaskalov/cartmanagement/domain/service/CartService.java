package com.adaskalov.cartmanagement.domain.service;

import com.adaskalov.cartmanagement.domain.exceptions.CartItemNotFoundException;
import com.adaskalov.cartmanagement.domain.exceptions.CartNotFoundException;
import com.adaskalov.cartmanagement.domain.models.Cart;
import com.adaskalov.cartmanagement.domain.models.CartId;
import com.adaskalov.cartmanagement.domain.models.CartItemId;

import java.util.List;
import java.util.Optional;

public interface CartService {

    List<Cart> findAll();

    Optional<Cart> findById(CartId id);

    void addItem(CartId orderId, CartItemId cartItemId) throws CartNotFoundException, CartItemNotFoundException;

    void deleteItem(CartId orderId, CartItemId cartItemId) throws CartNotFoundException, CartItemNotFoundException;
}
