package com.example.pizzacraftmvc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
         @Query("SELECT new com.example.pizzacraftmvc.UserTicketDTO(t.ticketNumber,u.name,u.pizzaName) FROM  User u JOIN Ticket t ON u.id=t.user.id")
         List<UserTicketDTO> joinTicket();

}
