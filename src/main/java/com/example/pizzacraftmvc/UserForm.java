package com.example.pizzacraftmvc;

public class UserForm {
    private  String name;
    private  String pizzaName;

    public String getPizzaName() {
        return pizzaName;
    }

    public String getName() {
        return name;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public void setName(String name) {
        this.name = name;
    }

}
