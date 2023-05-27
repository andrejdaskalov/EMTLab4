package com.adaskalov.parts.domain.models;

import com.adaskalov.parts.domain.valueobjects.PartManufacturerName;
import com.adaskalov.sharedkernel.domain.base.AbstractEntity;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;

import java.util.Objects;

@Getter
@Entity
public class PartManufacturer extends AbstractEntity<PartManufacturerId> {
    private PartManufacturerName name;

    public PartManufacturer(){
        super(PartManufacturerId.randomId(PartManufacturerId.class));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PartManufacturer that = (PartManufacturer) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }
}
