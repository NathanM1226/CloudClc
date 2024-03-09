package com.gcu.controllers;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.data.carsInterface;
//import com.gcu.data.carsModel;

@Controller
public class CarProductController
 {
    @Autowired
    private carsInterface carsInterface;

    @GetMapping("/cars")
    public ModelAndView getCarProducts() {
    ModelAndView modelAndView = new ModelAndView("cars.html"); 
    modelAndView.addObject("cars", carsInterface.getCars());
    return modelAndView;
}
}
