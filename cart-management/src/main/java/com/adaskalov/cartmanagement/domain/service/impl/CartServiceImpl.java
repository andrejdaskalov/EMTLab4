package com.adaskalov.cartmanagement.domain.service.impl;

import com.adaskalov.cartmanagement.domain.exceptions.CartItemNotFoundException;
import com.adaskalov.cartmanagement.domain.exceptions.CartNotFoundException;
import com.adaskalov.cartmanagement.domain.models.Cart;
import com.adaskalov.cartmanagement.domain.models.CartId;
import com.adaskalov.cartmanagement.domain.models.CartItem;
import com.adaskalov.cartmanagement.domain.models.CartItemId;
import com.adaskalov.cartmanagement.domain.repository.CartItemRepository;
import com.adaskalov.cartmanagement.domain.repository.CartRepository;
import com.adaskalov.cartmanagement.domain.service.CartService;
import com.adaskalov.sharedkernel.domain.events.AddedToCart;
import com.adaskalov.sharedkernel.domain.events.RemovedFromCart;
import com.adaskalov.sharedkernel.infra.DomainEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    private final DomainEventPublisher domainEventPublisher;

    public CartServiceImpl(CartRepository cartRepository, CartItemRepository cartItemRepository, DomainEventPublisher domainEventPublisher) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.domainEventPublisher = domainEventPublisher;
    }

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public Optional<Cart> findById(CartId id) {
        return cartRepository.findById(id);
    }

    @Override
    public void addItem(CartId orderId, CartItemId cartItemId) throws CartNotFoundException, CartItemNotFoundException {
        Cart cart = cartRepository.findById(orderId).orElseThrow(CartNotFoundException::new);
        CartItem item = cartItemRepository.findById(cartItemId).orElseThrow(CartItemNotFoundException::new);
        cart.addToCart(item);
        domainEventPublisher.publish(new AddedToCart(item.getPartNumber().getPartNumber(),item.getAmount()));
    }

    @Override
    public void deleteItem(CartId orderId, CartItemId cartItemId) throws CartNotFoundException, CartItemNotFoundException {
        Cart cart = cartRepository.findById(orderId).orElseThrow(CartNotFoundException::new);
        CartItem item = cartItemRepository.findById(cartItemId).orElseThrow(CartItemNotFoundException::new);
        cart.removeFromCart(item);
        domainEventPublisher.publish(new RemovedFromCart(item.getPartNumber().getPartNumber(),item.getAmount()));

    }
}
