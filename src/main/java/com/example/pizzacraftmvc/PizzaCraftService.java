package com.example.pizzacraftmvc;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaCraftService {


    private  UserRepository userRepository;

    public PizzaCraftService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }


    

     public  UserTicketDTO getUser(List<UserTicketDTO> userTicketDTOList){
        UserTicketDTO userTicketDTO =new UserTicketDTO();
        userTicketDTOList.forEach(userTicketDTO1 -> {
            userTicketDTO.setTicketNumber(userTicketDTO1.getTicketNumber());
            userTicketDTO.setUserName(userTicketDTO1.getUserName());
            userTicketDTO.setPizzaName(userTicketDTO1.getPizzaName());
        });

        return userTicketDTO;
     }


}
