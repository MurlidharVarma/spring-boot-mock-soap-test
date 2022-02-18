package com.lee.tester.controller;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.lee.tester.TesterApplication;
import com.lee.tester.client.SoapClient;
import com.lee.tester.config.MarshallerConfig;
import com.lee.tester.soap.NumberToDollars;
import com.lee.tester.soap.NumberToDollarsResponse;
import com.lee.tester.soap.NumberToWords;
import com.lee.tester.soap.NumberToWordsResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.context.annotation.Import;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.math.BigInteger;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

@Slf4j
@SpringBootTest(classes = TesterApplication.class)
@ActiveProfiles("local")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SoapControllerTest {

    private WireMockServer wireMockServer = new WireMockServer(wireMockConfig().port(8089));

    @Autowired
    SoapClient soapClient;

    @BeforeAll
    public void setup(){
        WireMock.configureFor("localhost", 8089);
        wireMockServer.start();
    }

    @AfterAll
    public void tearDown(){
        wireMockServer.stop();
    }

    @Test
    @DisplayName("Test if Number to Dollars")
    public void testNumberToDollars(){
        stubFor(post(urlEqualTo("/webservicesserver/numberconversion.wso"))
                .withHeader("Content-Type", WireMock.containing("text/xml"))
                .withRequestBody(WireMock.containing("NumberToDollars"))
                .willReturn(
                        aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type","text/xml")
                                .withBodyFile("NumberToDollarsResult.xml")
                )
        );

        NumberToDollars nd = new NumberToDollars();
        nd.setDNum(new BigDecimal(212.50));

        NumberToDollarsResponse res = this.soapClient.convertN2D(nd);

        Assert.assertEquals("I am Number to Dollars Result",res.getNumberToDollarsResult());
    }


    @Test
    @DisplayName("Test if Number to Words")
    public void testNumberToWords(){
        stubFor(post(urlEqualTo("/webservicesserver/numberconversion.wso"))
                .withHeader("Content-Type", WireMock.containing("text/xml"))
                .withRequestBody(WireMock.containing("NumberToWords"))
                .willReturn(
                        aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type","text/xml")
                                .withBodyFile("NumberToWordResult.xml")
                )
        );

        NumberToWords nw = new NumberToWords();
        nw.setUbiNum(new BigInteger("2022"));

        NumberToWordsResponse res = this.soapClient.convertN2W(nw);

        Assert.assertEquals("I am number to word result",res.getNumberToWordsResult());
    }
}
