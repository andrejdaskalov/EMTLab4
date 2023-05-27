package com.adaskalov.parts.domain.models;

import com.adaskalov.parts.domain.valueobjects.CarModelName;
import com.adaskalov.parts.domain.valueobjects.TrimLevel;
import com.adaskalov.sharedkernel.domain.base.AbstractEntity;
import com.adaskalov.sharedkernel.domain.valueobjects.Years;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.List;
import java.util.Objects;

@Entity
public class CarModel extends AbstractEntity<CarModelId> {

    private CarModelName name;
    private Years compatibleYears;

    private TrimLevel trimLevel;

    @ManyToMany(mappedBy = "carModels")
    private List<Part> parts;

    @ManyToOne
    private CarManufacturer manufacturer;

    public CarModel(){
        super(CarModelId.randomId(CarModelId.class));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CarModel carModel = (CarModel) o;
        return Objects.equals(name, carModel.name) && Objects.equals(compatibleYears, carModel.compatibleYears) && Objects.equals(trimLevel, carModel.trimLevel) && Objects.equals(parts, carModel.parts) && Objects.equals(manufacturer, carModel.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, compatibleYears, trimLevel, parts, manufacturer);
    }
}
