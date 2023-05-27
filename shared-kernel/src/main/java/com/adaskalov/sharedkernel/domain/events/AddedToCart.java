package com.adaskalov.sharedkernel.domain.events;

import lombok.Getter;

@Getter
public class AddedToCart extends DomainEvent{

    private String PartNumber;
    private int quantity;
    public AddedToCart() {
        super(TopicHolder.TOPIC_ADD_TO_CARD);
    }

    public AddedToCart(String partNumber, int quantity) {
        super(TopicHolder.TOPIC_ADD_TO_CARD);
        PartNumber = partNumber;
        this.quantity = quantity;
    }
}
