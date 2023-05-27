package com.adaskalov.sharedkernel.domain.valueobjects;

import com.adaskalov.sharedkernel.domain.base.ValueObject;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.NonNull;

@Embeddable
public class Money implements ValueObject {

    private double amount;

    @Enumerated(value = EnumType.STRING)
    private Currency currency;

    public Money(@NonNull double amount,@NonNull Currency currency){
        this.amount = amount;
        this.currency = currency;
    }

    protected Money() {
        this.amount = 0.0;
        this.currency = null;
    }

    public Money add(double amount){
        return new Money(this.amount + amount, this.currency);
    }

    public Money subtract(double amount){
        return new Money(this.amount - amount, this.currency);
    }

    public double getMoneyAmount(){
        return amount;
    }
    public Currency getCurrency(){
        return currency;
    }
}
