package org.example.library_system_spring.repositories;

import org.example.library_system_spring.entities.Client;
import org.example.library_system_spring.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan,Long> {
}
