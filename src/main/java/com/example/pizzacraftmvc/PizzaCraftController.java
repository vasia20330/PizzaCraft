package com.example.pizzacraftmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PizzaCraftController {

    private UserRepository userRepository;
    private ProcuctRepository procuctRepository;
    private PizzaCraftService pizzaCraftService;
    public PizzaCraftController(UserRepository userRepository, ProcuctRepository procuctRepository, PizzaCraftService pizzaCraftService) {
        this.userRepository = userRepository;
        this.procuctRepository = procuctRepository;
        this.pizzaCraftService = pizzaCraftService;
    }

    @GetMapping("/listUsers")
    public String listUsersWithTicket(Model model) {

        List<UserTicketDTO> userTicketDTOList = userRepository.joinTicket();
        model.addAttribute("users", userTicketDTOList);
        return "listUsers";
    }




    @GetMapping("/form")
    public String formForPizzaBootstrap(Model model) {

        User user=new User();

        model.addAttribute("user", user);

        return "boostrapPizza";
    }
    @PostMapping("/submit")
    public String postSubmitUserBootstrap(@ModelAttribute User user, Model model) {


        Ticket ticket=new Ticket();
        user.addTicket(ticket);
        ticket.setUser(user);
        userRepository.save(user);
//        SelectionPizza selectionPizza=new SelectionPizza(userRepository);
        pizzaCraftService.checkAndIncrement(user.getPizzaName());


        List<UserTicketDTO> userTicketDTOList = userRepository.joinTicket();
        model.addAttribute("users", pizzaCraftService.getUser(userTicketDTOList));

        return "boostrapSubmitPizza";
    }
    @GetMapping("/formAdmin")
    public  String formAdmin(){
        return "adminFormBootstrap";
    }
    @GetMapping("/listProduct")
    public  String listProduct(Model model){
        model.addAttribute("products",procuctRepository.findAll());

        return "listProduct";
    }
}
