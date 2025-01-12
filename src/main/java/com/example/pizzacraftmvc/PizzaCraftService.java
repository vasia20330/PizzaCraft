package com.example.pizzacraftmvc;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaCraftService {


    private  UserRepository userRepository;
    private ProcuctRepository procuctRepository;


    public PizzaCraftService(UserRepository userRepository, ProcuctRepository procuctRepository) {
        this.userRepository = userRepository;
        this.procuctRepository = procuctRepository;
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

       public void checkAndIncrement(String productString){
           Optional<Products> productsOptional=procuctRepository.findByProduct(productString);

          if (productsOptional.isPresent()){
              Products products=productsOptional.get();
              products.setCount(products.getCount()+1);
              procuctRepository.save(products);
          }else {
              Products products=new Products();
              products.setProduct(productString);
              products.setCount(1);
              procuctRepository.save(products);
       }

    }

}
