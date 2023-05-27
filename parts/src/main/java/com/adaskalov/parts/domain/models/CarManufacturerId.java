package com.adaskalov.parts.domain.models;

import com.adaskalov.sharedkernel.domain.base.DomainObjectId;
import lombok.NonNull;

public class CarManufacturerId extends DomainObjectId{
    protected CarManufacturerId(@NonNull String uuid) {
        super(uuid);
    }

    private CarManufacturerId(){
        super(CarModelId.randomId(CarModelId.class).getId());
    }

    public static CarManufacturerId of(String uuid){
        var p = new CarManufacturerId(uuid);
        return p;
    }

    public String getCarManufacturerId(){
        return this.getId();
    }


}
