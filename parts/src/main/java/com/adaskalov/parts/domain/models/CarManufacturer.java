package com.adaskalov.parts.domain.models;

import com.adaskalov.parts.domain.valueobjects.CarManufacturerName;
import com.adaskalov.sharedkernel.domain.base.AbstractEntity;
import jakarta.persistence.Entity;
import lombok.Getter;

import java.util.Objects;


@Entity
public class CarManufacturer extends AbstractEntity<CarManufacturerId> {

    private CarManufacturerName name;

    public CarManufacturer(){
        super(CarManufacturerId.randomId(CarManufacturerId.class));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CarManufacturer that = (CarManufacturer) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }

}
