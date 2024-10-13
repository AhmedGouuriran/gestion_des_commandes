package com.fsjdida.gestion_des_commandes.Dao;

import com.fsjdida.gestion_des_commandes.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository
public interface OrderDao extends JpaRepository<Order , Long> {

    Order findByOrderDate(Date date);
}
