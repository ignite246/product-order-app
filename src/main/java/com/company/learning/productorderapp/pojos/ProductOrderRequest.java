package com.company.learning.productorderapp.pojos;

/**
 * This class is used to hold incoming product order request from the client app
 */
public class ProductOrderRequest {

    /*___ Ordered Product Details ____*/
    private Integer productName;
    private Integer productPrice;
    private Integer buyerUserId;

    /*___ Payee's Details and Payee's Card Details ___*/
    private String payeeFirstName;
    private String payeeLastName;
    private Integer payeeCardNumber;
    private Integer payeeCardCVVNumber;

}
