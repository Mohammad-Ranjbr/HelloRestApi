package com.mycompany.api.controller;

import com.mycompany.api.exception.UnitConversionException;
import com.mycompany.api.payload.ConversionDetails;
import com.mycompany.api.payload.UnitConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/unit-conversion")
public class UnitConversionController {

    @PostMapping
    public ResponseEntity<ConversionDetails> convert(@RequestBody ConversionDetails conversionDetails){
        try {
            UnitConverter.convert(conversionDetails);
        } catch (UnitConversionException unitConversionException){
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(conversionDetails, HttpStatus.OK);
    }

}
