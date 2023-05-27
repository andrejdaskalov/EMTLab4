package com.adaskalov.cartmanagement.domain.models;

import com.adaskalov.parts.domain.models.Part;
import com.adaskalov.parts.domain.models.PartNumber;
import com.adaskalov.sharedkernel.domain.base.AbstractEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NonNull;

import java.util.Objects;

@Entity
@Data
public class CartItem extends AbstractEntity<CartItemId> {

    @AttributeOverride(name = "id", column = @Column(name = "part-num", nullable = false))
    private PartNumber partNumber;

    private int amount;

    public CartItem(@NonNull PartNumber partNumber, int amount){
        super(CartItemId.randomId(CartItemId.class));
        this.partNumber = partNumber;
        this.amount = amount;
    }
    protected CartItem(){
        super(CartItemId.randomId(CartItemId.class));
        partNumber = null;
        amount = 0;
    }


    public void addAmount(){
        amount++;
    }

    public void subtractAmount(){
        amount--;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CartItem cartItem = (CartItem) o;
        return amount == cartItem.amount && Objects.equals(partNumber, cartItem.partNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), partNumber, amount);
    }
}
