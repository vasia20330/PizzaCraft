package com.example.pizzacraftmvc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(EmployeeRepository employeeRepository, PasswordEncoder passwordEncoder) {
        this.employeeRepository = employeeRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void run(String... args) throws Exception {
        initData();
    }
    private  void initData(){

      if (!employeeRepository.existsById(1L)){
          Employee employee =new Employee();
          employee.setUserName("admin");
          employee.setPassword(passwordEncoder.encode("root"));
          employee.setRole("ADMIN");
          employeeRepository.save(employee);
      }
      if (!employeeRepository.existsById(2L)){
          Employee cook=new Employee();
          cook.setUserName("cook");
          cook.setPassword(passwordEncoder.encode("root"));
          cook.setRole("COOK");
          employeeRepository.save(cook);
      }


    }
}
