package com.example.pizzacraftmvc;

import org.apache.logging.log4j.message.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MyController {

    private UserRepository userRepository;

    public MyController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/listUsers")
    public String listUsersWithTicket(Model model) {

        List<UserTicketDTO> userTicketDTOList = userRepository.joinTicket();
        model.addAttribute("users", userTicketDTOList);
        return "listUsers";
    }

    @GetMapping("/form")
    public String formForPizza(Model model) {

        User user=new User();

        model.addAttribute("user", user);

        return "pizzaFront";
    }

    @PostMapping("/submit")
    public String postSubmitUser(@ModelAttribute User user, Model model) {

        Ticket ticket=new Ticket();
        user.addTicket(ticket);
        ticket.setUser(user);
        userRepository.save(user);

        MyService myService=new MyService(userRepository);

        List<UserTicketDTO> userTicketDTOList = userRepository.joinTicket();
        model.addAttribute("users", myService.getUser(userTicketDTOList));

        return "submit";
    }
    @GetMapping("/formBootstrap")
    public String formForPizzaBootstrap(Model model) {

        User user=new User();

        model.addAttribute("user", user);

        return "boostrapPizza";
    }
    @PostMapping("/submitBootstrap")
    public String postSubmitUserBootstrap(@ModelAttribute User user, Model model) {

        Ticket ticket=new Ticket();
        user.addTicket(ticket);
        ticket.setUser(user);
        userRepository.save(user);

        MyService myService=new MyService(userRepository);

        List<UserTicketDTO> userTicketDTOList = userRepository.joinTicket();
        model.addAttribute("users", myService.getUser(userTicketDTOList));

        return "boostrapSubmitPizza";
    }
    @GetMapping("/formAdmin")
    public  String formAdmin(){
        return "adminFormBootstrap";
    }

}
