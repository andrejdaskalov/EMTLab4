package com.adaskalov.cartmanagement.domain.models;

import com.adaskalov.sharedkernel.domain.base.DomainObjectId;
import lombok.Getter;

@Getter
public class CartId extends DomainObjectId {
    protected CartId(String uuid) {
        super(uuid);
    }

    private CartId(){
        super(CartId.randomId(CartId.class).getId());
    }

    public static CartId of(String uuid){
        var p = new CartId(uuid);
        return p;
    }

    public String getCartId(){
        return this.getId();
    }


}
