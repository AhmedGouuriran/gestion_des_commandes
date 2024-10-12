package com.fsjdida.gestion_des_commandes.models;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity //
@Table(name = "products")
@Data // using lombok getter stter
@AllArgsConstructor
@NoArgsConstructor // constructeur par defaut
@Getter
@Setter
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_product   ;

    @Column(nullable = false)
    private   String name;

    @Column(nullable = true)
    private   String description;

    @Column(nullable = false)
    private BigDecimal price;

    @OneToMany(mappedBy = "product" , cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<OrderItem> orderItems;

}
