package com.fsjdida.gestion_des_commandes.Dao;

import com.fsjdida.gestion_des_commandes.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {

Customer findByFirstNameAndLastName(String firstName, String lastName);
Customer findByFirstName(String firstName);

}
