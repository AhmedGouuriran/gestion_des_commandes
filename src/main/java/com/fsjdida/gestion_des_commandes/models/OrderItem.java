package com.fsjdida.gestion_des_commandes.models;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity //
@Table(name = "orderItems")
@Data // using lombok getter stter
@AllArgsConstructor
@NoArgsConstructor // constructeur par defaut
@Getter
@Setter
@ToString
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_orderitem   ;


    @Column(nullable = false)
    private  Integer quantity ;


    @ManyToOne
    private  Product product;

    @ManyToOne
    private Order order;
}
