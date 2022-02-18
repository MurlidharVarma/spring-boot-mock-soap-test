package com.lee.tester.controller;

import com.lee.tester.client.SoapClient;
import com.lee.tester.soap.NumberToDollars;
import com.lee.tester.soap.NumberToDollarsResponse;
import com.lee.tester.soap.NumberToWords;
import com.lee.tester.soap.NumberToWordsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.BigInteger;

@RestController
@Slf4j
public class SoapController {

    @Autowired
    SoapClient soapClient;

    @GetMapping("/n2d/{num}")
    public NumberToDollarsResponse convertN2D(@PathVariable  String num){
        NumberToDollars req = new NumberToDollars();
        req.setDNum(new BigDecimal(num));
        return soapClient.convertN2D(req);

    }

    @GetMapping("/n2w/{num}")
    public NumberToWordsResponse convertN2W(@PathVariable  String num){
        NumberToWords req = new NumberToWords();
        req.setUbiNum(new BigInteger(num));
        return soapClient.convertN2W(req);

    }
}
