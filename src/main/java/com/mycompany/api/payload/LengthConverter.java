package com.mycompany.api.payload;

public class LengthConverter {

    public static void kilometer2Mile(ConversionDetails conversionDetails){
        float km = conversionDetails.getFromValue();
        float miles = km * 0.621371f;
        conversionDetails.setToValue(miles);
    }

    public static void mile2Kilometer(ConversionDetails conversionDetails){
        float miles = conversionDetails.getFromValue();
        float km = miles * 1.60934f;
        conversionDetails.setToValue(km);
    }

}
