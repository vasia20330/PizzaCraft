package com.example.pizzacraftmvc;

import java.util.Random;

public class UserTicketDTO {
    private  int ticketNumber;
    private String userName;
    private  String pizzaName;

    public  UserTicketDTO (){

    }
    public UserTicketDTO(int ticketNumber, String userName, String pizzaName) {
        this.ticketNumber = ticketNumber;
        this.userName = userName;
        this.pizzaName = pizzaName;
    }

    public String getUserName() {
        return userName;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }
}
