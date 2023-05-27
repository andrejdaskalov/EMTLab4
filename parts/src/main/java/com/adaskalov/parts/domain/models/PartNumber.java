package com.adaskalov.parts.domain.models;

import com.adaskalov.sharedkernel.domain.base.DomainObjectId;
import lombok.NonNull;

public class PartNumber extends DomainObjectId{
    public PartNumber(@NonNull String uuid) {
        super(uuid);
    }

    private PartNumber(){
        super(PartNumber.randomId(PartNumber.class).getId());
    }

    public static PartNumber of(String uuid){
        var p = new PartNumber(uuid);
        return p;
    }

    public String getPartNumber(){
        return this.getId();
    }



}
