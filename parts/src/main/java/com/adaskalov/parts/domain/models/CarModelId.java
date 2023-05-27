package com.adaskalov.parts.domain.models;

import com.adaskalov.sharedkernel.domain.base.DomainObjectId;
import lombok.NonNull;

public class CarModelId extends DomainObjectId {
    public CarModelId(@NonNull String uuid) {
        super(uuid);
    }

    private CarModelId(){
        super(CarModelId.randomId(CarModelId.class).getId());
    }

    public static CarModelId of(String uuid){
        var p = new CarModelId(uuid);
        return p;
    }

    public String getCarModelId(){
        return this.getId();
    }
}
