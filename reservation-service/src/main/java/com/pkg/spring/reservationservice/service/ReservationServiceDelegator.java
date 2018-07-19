package com.pkg.spring.reservationservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.*;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.pkg.spring.reservationservice.proxy.ReservationRestProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.*;

import java.util.Date;

/**
 * Created by sdixit9 on 6/28/2018.
 */
@Service
public class ReservationServiceDelegator {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ReservationRestProxy reservationRestProxy;

    @com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand(fallbackMethod = "callReservationServiceAndGetData_Fallback")
    public String callReservationServiceandGetData(String pnr) {

        System.out.println("Getting Reservation details for " + pnr +" from callReservationServiceandGetData()");
        /*
        String response = restTemplate
                .exchange("http://localhost:6699/getReservationDetails/{pnr}"
                        , HttpMethod.GET
                        , null
                        , new ParameterizedTypeReference<String>() {
                        }, pnr).getBody();*/

        String response=reservationRestProxy.getStudentDetails(pnr).toString();
        System.out.println("Response Received as " + response + " -  " + new Date());

        return "NORMAL FLOW !!! - Reservation ID -  " + pnr + " :::  " +
                " Passenger Details " + response + " -  " + new Date();
    }

    @SuppressWarnings("unused")
    private String callReservationServiceAndGetData_Fallback(String pnr) {

        System.out.println("Reservation Service is down!!! fallback route enabled...");

        return "CIRCUIT BREAKER ENABLED!!! No Response From Reservation Service at this moment. " +
                " Service will be back shortly - " + new Date();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
