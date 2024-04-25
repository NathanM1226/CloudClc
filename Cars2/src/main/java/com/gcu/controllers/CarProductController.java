package com.gcu.controllers;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.gcu.data.carsInterface;
import com.gcu.data.carsModel;

import org.springframework.web.bind.annotation.PostMapping;




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

    @GetMapping("/createCar")
    public String newCar(Model model) {
        model.addAttribute("title", "Add New Product");
        model.addAttribute("car", new carsModel());
        return "createCar";
    }

    @PostMapping("/processNew")
    public String processNew(carsModel car, BindingResult bindingResult, Model model) {
        carsInterface.addOne(car);
        model.addAttribute("title", "Added an item");
        return "redirect:/cars";
    }

    @GetMapping("/edit")
    public String editCar(carsModel carModel, Model model) {
        model.addAttribute("title", "Edit car");
		model.addAttribute("car", carModel);
        return "editCar";
    }

    @PostMapping("/processEdit")
    public String processEdit(carsModel car, BindingResult bindingResult, Model model) {
        carsInterface.updateOne(car.getId(), car);

        List<carsModel> items = carsInterface.getCars();

        model.addAttribute("carsInterface", items); 
        return "redirect:/cars";
    }

    @PostMapping("/delete/{id}")
    public String deleteCar(carsModel car, BindingResult bindingResult, Model model){
        carsInterface.deleteOne(car.getId());

        List<carsModel> items = carsInterface.getCars();
        model.addAttribute("carsInterface", items); 
        return "redirect:/cars";
    }
}
