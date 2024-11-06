package org.example.library_system_spring.services;

import org.example.library_system_spring.entities.Loan;
import org.example.library_system_spring.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    public List<Loan> findAllLoans(){
        return loanRepository.findAll();
    }

}
