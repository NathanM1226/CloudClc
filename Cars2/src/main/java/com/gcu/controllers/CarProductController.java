package com.gcu.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.data.carsInterface;

@Controller
@Slf4j 
public class CarProductController {

    @Autowired
    private carsInterface carsInterface;

    @GetMapping("/cars")
    public ModelAndView getCarProducts() {
        log.info("Fetching car products"); // Log a message indicating the start of the method
        ModelAndView modelAndView = new ModelAndView("cars.html"); 
        modelAndView.addObject("cars", carsInterface.getCars());
        log.info("Retrieved car products: {}", carsInterface.getCars()); // Log the retrieved car products
        return modelAndView;
    }
}
