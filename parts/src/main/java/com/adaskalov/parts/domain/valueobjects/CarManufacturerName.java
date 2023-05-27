package com.adaskalov.parts.domain.valueobjects;

import com.adaskalov.sharedkernel.domain.base.ValueObject;
import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class CarManufacturerName implements ValueObject {
    private final String manufacturerName;

    public CarManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    protected CarManufacturerName() {
        manufacturerName = "";
    }
}
