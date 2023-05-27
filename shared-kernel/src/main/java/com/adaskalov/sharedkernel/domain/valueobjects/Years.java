package com.adaskalov.sharedkernel.domain.valueobjects;

import com.adaskalov.sharedkernel.domain.base.ValueObject;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDate;

@Getter
@Embeddable
public class Years implements ValueObject {
    private final LocalDate fromDate;
    private final LocalDate toDate;

    public Years(@NonNull LocalDate fromDate, @NonNull LocalDate toDate) {
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    protected Years() {
        fromDate = null;
        toDate = null;
    }

    public boolean isBetween(LocalDate date){
        return date.isAfter(fromDate) && date.isBefore(toDate);
    }

}
