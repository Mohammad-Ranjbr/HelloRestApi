package com.mycompany.api.exception;

public class UnitConversionException extends RuntimeException {
    public UnitConversionException(String invalidFromAndToUnits) {
        super(invalidFromAndToUnits);
    }

}
