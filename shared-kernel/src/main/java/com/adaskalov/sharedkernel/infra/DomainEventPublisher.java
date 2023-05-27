package com.adaskalov.sharedkernel.infra;

import com.adaskalov.sharedkernel.domain.events.DomainEvent;

public interface DomainEventPublisher {
    void publish(DomainEvent event);
}
