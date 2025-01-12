package com.example.pizzacraftmvc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProcuctRepository extends JpaRepository<Products,Long> {

    Optional<Products> findByProduct(String product);
}
