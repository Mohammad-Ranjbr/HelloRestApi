package com.mycompany.api.payload;

import com.mycompany.api.exception.UnitConversionException;

public class UnitConverter {

    public static void convert(ConversionDetails conversionDetails){
        String fromUnit = conversionDetails.getFromUnit();
        String toUnit = conversionDetails.getToUnit();

        if(fromUnit.equals("km") && toUnit.equals("mile")){
            LengthConverter.kilometer2Mile(conversionDetails);
        } else if(fromUnit.equals("mile") && toUnit.equals("km")){
            LengthConverter.mile2Kilometer(conversionDetails);
        } else {
            throw new UnitConversionException("Invalid From and To Units");
        }
    }

}
