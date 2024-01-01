package com.mycompany.api.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConversionDetails {

    private String fromUnit;
    private float fromValue;
    private String toUnit;
    private float toValue;

}
