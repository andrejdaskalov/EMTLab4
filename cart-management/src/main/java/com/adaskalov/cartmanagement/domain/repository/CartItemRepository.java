package com.adaskalov.cartmanagement.domain.repository;

import com.adaskalov.cartmanagement.domain.models.CartItem;
import com.adaskalov.cartmanagement.domain.models.CartItemId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, CartItemId> {
}
