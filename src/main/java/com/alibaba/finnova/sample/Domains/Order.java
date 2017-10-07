package com.alibaba.finnova.sample.Domains;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "order_Table")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String productType;
    private String buyer;
    private String description;
    private BigDecimal value;
    private int quantity;
    private int volume;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="USER_ID")
    private User user;
}
