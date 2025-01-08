package com.example.pizzacraftmvc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        initData();
    }
    private  void initData(){

      if (!adminRepository.existsById(1L)){
          Admin admin=new Admin();
          admin.setUserName("admin");
          admin.setPassword(passwordEncoder.encode("root"));
          admin.setRole("ADMIN");
          adminRepository.save(admin);
      }
    }
}
