package com.adaskalov.parts.domain.models;

import com.adaskalov.sharedkernel.domain.base.DomainObjectId;
import lombok.NonNull;

public class PartManufacturerId extends DomainObjectId {
    protected PartManufacturerId(@NonNull String uuid) {
        super(uuid);
    }

    private PartManufacturerId(){
        super(PartManufacturerId.randomId(PartManufacturerId.class).getId());
    }

    public static PartManufacturerId of(String uuid){
        var p = new PartManufacturerId(uuid);
        return p;
    }

    public String getPartManufacturerId(){
        return this.getId();
    }
}
