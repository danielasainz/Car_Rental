package com.sainz.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    carRepository carRepo;

    @RequestMapping("/")
    public String showIndex(Model model) {
        model.addAttribute("shop", carRepo.findAll());
        return "index";
    }

    @RequestMapping("/add")
    public String addCar(Model model) {
        model.addAttribute("aCar", new Car());
        return "addCar";
    }

    @RequestMapping("/savecar")
    public String saveCar(@ModelAttribute("aCar") Car toSave, BindingResult result) {

        if (result.hasErrors()) {
            return "addCar";
        }
        carRepo.save(toSave);
        return "redirect:/";
    }

    @RequestMapping("/changestatus/{id}")
    public String rentReturn(@PathVariable("id") long id) {
        Car thisCar = carRepo.findById(id).get();
        thisCar.setAvailable(!thisCar.getAvailable());
        carRepo.save(thisCar);
        return "redirect:/";
    }

    @RequestMapping("/update/{id}")
    public String updateCar(@PathVariable("id") long id, Model model)
    {
        model.addAttribute("aCar", carRepo.findById(id).get());
        return "addCar";
    }

    @RequestMapping("/delete/{id}")
     public String deleteCar (@PathVariable("id") long id){
            carRepo.deleteById(id);
        return "redirect:/";
    }
}




