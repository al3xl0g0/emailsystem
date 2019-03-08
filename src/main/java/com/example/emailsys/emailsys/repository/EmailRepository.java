package com.example.emailsys.emailsys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.emailsys.emailsys.model.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email,Long>{

}
