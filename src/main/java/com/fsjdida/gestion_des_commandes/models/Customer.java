package com.fsjdida.gestion_des_commandes.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity //
@Table(name = "customer")
@Data // using lombok getter stter
@AllArgsConstructor
@NoArgsConstructor // constructeur par defaut
@Getter
@Setter
@ToString
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_customer;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = true)
    private String email;

    @OneToMany(mappedBy = "customer_R" , cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Order> orders;


}
