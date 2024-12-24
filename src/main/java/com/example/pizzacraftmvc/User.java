package com.example.pizzacraftmvc;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String pizzaName;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Ticket> ticketList=new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }
    public  void  addTicket(Ticket ticket){
        ticketList.add(ticket);
        ticket.setUser(this);
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }
}
