package org.example.library_system_spring.resources;


import org.example.library_system_spring.entities.Loan;
import org.example.library_system_spring.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping
    public List<Loan> getAllLoans(){
        return loanService.findAllLoans();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Loan> getById(@PathVariable Long id){
        Loan loan = loanService.findById(id);
        return ResponseEntity.ok().body(loan);
    }

}
