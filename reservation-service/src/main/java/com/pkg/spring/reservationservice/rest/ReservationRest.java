package com.pkg.spring.reservationservice.rest;

import com.pkg.spring.reservationservice.service.ReservationServiceDelegator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sdixit9 on 6/28/2018.
 */

@RestController
public class ReservationRest {
    @Autowired
    ReservationServiceDelegator reservationServiceDelegator;
    @RequestMapping(value = "/getReservationDetails/{pnr}", method = RequestMethod.GET)
    public List<String> getStudents(@PathVariable String pnr) {
        System.out.println("Getting Reservation details for " + pnr);
        List<String> passList = Arrays.asList(reservationServiceDelegator.callReservationServiceandGetData(pnr));
        if (passList == null) {
            passList = new ArrayList<String>();
            String passDefault = "Not Found";
            passList.add(passDefault);
        }
        return passList;
    }
}
