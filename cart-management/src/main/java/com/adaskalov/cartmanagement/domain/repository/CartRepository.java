package com.adaskalov.cartmanagement.domain.repository;

import com.adaskalov.cartmanagement.domain.models.Cart;
import com.adaskalov.cartmanagement.domain.models.CartId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, CartId> {
}
