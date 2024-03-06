package com.company.learning.productorderapp.entities;

import jakarta.persistence.*;

/**
 * This class is an entity and holds ProductOrder Detail
 */
@Entity
@Table(name = "product_order_details")
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productOrderId;
    private String productName;
    private Integer productPrice;
    private Integer purchaserUserId;
}
