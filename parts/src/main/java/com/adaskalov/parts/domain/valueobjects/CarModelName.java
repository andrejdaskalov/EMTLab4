package com.adaskalov.parts.domain.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class CarModelName {
    private final String modelName;

    public CarModelName(String modelName) {
        this.modelName = modelName;
    }

    protected CarModelName() {
        modelName = "";
    }
}
