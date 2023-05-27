package com.adaskalov.sharedkernel.domain.events;

import lombok.Getter;

@Getter
public class RemovedFromCart extends DomainEvent{
    private String PartNumber;
    private int quantity;
    public RemovedFromCart() {
        super(TopicHolder.TOPIC_REMOVE_FROM_CART);
    }

    public RemovedFromCart(String partNumber, int quantity) {
        super(TopicHolder.TOPIC_REMOVE_FROM_CART);
        PartNumber = partNumber;
        this.quantity = quantity;
    }
}
