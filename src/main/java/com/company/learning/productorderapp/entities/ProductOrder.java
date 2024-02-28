package com.company.learning.productorderapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * This class is an entity and holds ProductOrder Detail
 */

@Entity
@Table(name = "product_order_details")
public class ProductOrder {
    private Integer productOrderId;
    private String productName;
    private Integer productPrice;
    private Integer purchaserUserId;
}
