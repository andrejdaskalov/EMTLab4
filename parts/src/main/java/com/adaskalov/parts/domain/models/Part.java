package com.adaskalov.parts.domain.models;

import com.adaskalov.sharedkernel.domain.base.AbstractEntity;
import com.adaskalov.sharedkernel.domain.valueobjects.Money;
import com.adaskalov.parts.domain.valueobjects.PartName;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="part")
@Getter
public class Part extends AbstractEntity<PartNumber> {

    private PartName name;

    private Money price;

    @Column(name="quantity",nullable = false)
    private int numberInStock;

    @ManyToOne
    private PartManufacturer manufacturer;

    @ManyToMany
    private List<CarModel> carModels;


    public Part(){
        super(PartNumber.randomId(PartNumber.class));
        carModels = new ArrayList<>();
    }

    public void addNumberInStock(int amount){
        numberInStock += amount;
    }

    public void removeNumberInStock(int amount){
        numberInStock -= amount;
    }

    public void addCarModel(CarModel model){
        carModels.add(model);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Part part = (Part) o;
        return numberInStock == part.numberInStock && Objects.equals(name, part.name) && Objects.equals(price, part.price) && Objects.equals(manufacturer, part.manufacturer) && Objects.equals(carModels, part.carModels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, price, numberInStock, manufacturer, carModels);
    }
}
