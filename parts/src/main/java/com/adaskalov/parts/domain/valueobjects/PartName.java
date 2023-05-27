package com.adaskalov.parts.domain.valueobjects;

import com.adaskalov.sharedkernel.domain.base.ValueObject;
import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class PartName implements ValueObject {

    private final String partName;

    public PartName(String partName) {
        this.partName = partName;
    }

    protected PartName() {
        partName = "";
    }
//    public String getPartName(){
//        return partName;
//    }

}
