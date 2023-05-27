package com.adaskalov.parts.domain.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Getter;

@Embeddable
@Getter
public class PartManufacturerName {

    private final String partManufacturerName;

    protected PartManufacturerName() {
        partManufacturerName = "";
    }
    public PartManufacturerName(String partManufacturerName) {
        this.partManufacturerName = partManufacturerName;
    }
//    public String getPartManufacturerName(){
//        return partManufacturerName;
//    }
}
