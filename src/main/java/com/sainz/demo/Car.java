package com.sainz.demo;

/*

You're going to develop a car rental application. Well, some of it.

You are going to develop the part of it that tells you whether the car is available or not.

Each car should have the following details:

- Brand

- Model

- Colour

- Image

- Available

You should be able to save an image url to the database (do not use Cloudinary yet), and retrieve pictures of available cars.

It is OK if the image sizes are different right now - we will work on that later.

List out all cars, whether they are available or not. Available cars should show that you can rent them, and unavailable cars should show a return option.


 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String brand;

    @NotEmpty
    private String model;

    @NotEmpty
    private String color;

    @NotEmpty
    private String image;

    @NotNull
    private Boolean available;

    public Car(){
        this.available=false;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
