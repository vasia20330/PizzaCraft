package com.example.pizzacraftmvc;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Random;

@Entity
public class Ticket  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    private int ticketNumber;

    public Ticket(){
        Random random=new Random();
        int ticketNumber=random.nextInt(300);
        if(ticketNumber==0){
            ticketNumber+=5;
        }
        setTicketNumber(ticketNumber);
    }

    public Long getId() {
        return Id;
    }

    public User getUser() {
        return user;
    }

    public int getTicketNumber() {

        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
