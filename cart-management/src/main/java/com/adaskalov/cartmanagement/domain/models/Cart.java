package com.adaskalov.cartmanagement.domain.models;

import com.adaskalov.sharedkernel.domain.base.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Entity
@Data
public class Cart extends AbstractEntity<CartId> {

    @OneToMany
    private List<CartItem> itemList;

    public Cart(@NonNull List<CartItem> itemList) {
        super(CartId.randomId(CartId.class));
        this.itemList = itemList;
    }

    protected Cart() {
        super(CartId.randomId(CartId.class));
        this.itemList = null;
    }

    public void addToCart(CartItem item){
        if (itemList.contains(item)){
            item.addAmount();
            return;
        }
        itemList.add(item);
    }

    public void removeFromCart(CartItem item){
        itemList.remove(item);
    }
}
