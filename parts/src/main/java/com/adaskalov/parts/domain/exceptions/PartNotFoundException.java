package com.adaskalov.parts.domain.exceptions;

public class PartNotFoundException extends Exception{
    public PartNotFoundException() {
        super("Part Not Found");
    }
}
