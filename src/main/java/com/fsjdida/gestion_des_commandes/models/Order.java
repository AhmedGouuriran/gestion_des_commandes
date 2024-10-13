package com.fsjdida.gestion_des_commandes.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_order;

    private Date orderDate;

    private BigDecimal totalAmount;


    @ManyToOne
    private Customer customer_R;

    @OneToMany(mappedBy = "order" , cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<OrderItem> orderItemList;

}
