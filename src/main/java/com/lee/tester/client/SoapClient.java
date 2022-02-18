package com.lee.tester.client;

import com.lee.tester.soap.NumberToDollars;
import com.lee.tester.soap.NumberToDollarsResponse;
import com.lee.tester.soap.NumberToWords;
import com.lee.tester.soap.NumberToWordsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.ws.client.core.WebServiceTemplate;

@Service
public class SoapClient {

    private Jaxb2Marshaller marshaller;

    private WebServiceTemplate template;

    @Value("${soap.ws}")
    private String WsUrl;

    public SoapClient(final Jaxb2Marshaller marshaller){
        this.marshaller = marshaller;
        this.template = new WebServiceTemplate(this.marshaller);
    }

    public NumberToWordsResponse convertN2W(NumberToWords request){
        NumberToWordsResponse response = (NumberToWordsResponse) template.marshalSendAndReceive(WsUrl+"/webservicesserver/numberconversion.wso",request);
        return response;
    }

    public NumberToDollarsResponse convertN2D(NumberToDollars request){
        NumberToDollarsResponse response = (NumberToDollarsResponse) template.marshalSendAndReceive(WsUrl+"/webservicesserver/numberconversion.wso",request);
        return response;
    }
}
