package org.example.library_system_spring.repositories;

import org.example.library_system_spring.entities.Book;
import org.example.library_system_spring.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
}
