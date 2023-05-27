package com.adaskalov.parts.domain.listeners;

import com.adaskalov.parts.domain.exceptions.PartNotFoundException;
import com.adaskalov.parts.domain.models.PartNumber;
import com.adaskalov.parts.domain.service.PartService;
import com.adaskalov.sharedkernel.domain.events.AddedToCart;
import com.adaskalov.sharedkernel.domain.events.DomainEvent;
import com.adaskalov.sharedkernel.domain.events.RemovedFromCart;
import com.adaskalov.sharedkernel.domain.events.TopicHolder;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PartEventListener {
    private final PartService partService;

    @KafkaListener(topics = TopicHolder.TOPIC_ADD_TO_CARD, groupId = "partsCatalog")
    public void consumeAddToCartEvent(String message) throws JsonProcessingException, PartNotFoundException {
        AddedToCart event = DomainEvent.fromJson(message, AddedToCart.class);
        partService.cartItemAdded(PartNumber.of(event.getPartNumber()),event.getQuantity());
    }

    @KafkaListener(topics = TopicHolder.TOPIC_REMOVE_FROM_CART, groupId = "partsCatalog")
    public void consumeRemoveFromCartEvent(String message) throws JsonProcessingException, PartNotFoundException {
        RemovedFromCart event = DomainEvent.fromJson(message, RemovedFromCart.class);
        partService.cartItemRemoved(PartNumber.of(event.getPartNumber()),event.getQuantity());
    }

}
