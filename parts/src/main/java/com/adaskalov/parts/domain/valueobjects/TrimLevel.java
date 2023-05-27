package com.adaskalov.parts.domain.valueobjects;

import com.adaskalov.sharedkernel.domain.base.ValueObject;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NonNull;

@Embeddable
@Getter
public class TrimLevel implements ValueObject {
    private final String motorSpecs;
    private final String trimSpecs;

    public TrimLevel(@NonNull String motorSpecs, @NonNull String trimSpecs) {
        this.motorSpecs = motorSpecs;
        this.trimSpecs = trimSpecs;
    }
     protected TrimLevel(){
        motorSpecs = "";
        trimSpecs = "";
     }


}
