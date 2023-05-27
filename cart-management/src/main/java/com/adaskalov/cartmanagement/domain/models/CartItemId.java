package com.adaskalov.cartmanagement.domain.models;

import com.adaskalov.sharedkernel.domain.base.DomainObjectId;
import lombok.NonNull;

public class CartItemId extends DomainObjectId {

    protected CartItemId(@NonNull String uuid) {
        super(uuid);
    }
    private CartItemId(){
        super(CartItemId.randomId(CartItemId.class).getId());
    }

    public static CartItemId of(String uuid){
        var p = new CartItemId(uuid);
        return p;
    }

    public String getCartItemId(){
        return this.getId();
    }
}
