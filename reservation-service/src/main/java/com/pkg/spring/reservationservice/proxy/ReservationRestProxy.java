package com.pkg.spring.reservationservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
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

@FeignClient(name="RESERVATIONSERVICE3")
public interface ReservationRestProxy {
    @RequestMapping(value = "/feign/getReservationDetails/{pnr}", method = RequestMethod.GET)
    public List<String> getStudentDetails(@PathVariable(value="pnr") String pnr) ;

}
