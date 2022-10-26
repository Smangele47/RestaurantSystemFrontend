package za.ac.cput.factory;

import za.ac.cput.domain.Order;
import za.ac.cput.util.GenericHelper;

/*
    OrderFactory.java
    Author: Damone Hartnick 219093717
    Date: October 2022
*/
public class OrderFactory {

    public static Order createOrder(String  orderID, String orderDetails, String orderType, int orderQuantity) {

        if (GenericHelper.isNullorEmpty(orderDetails) || GenericHelper.isNullorEmpty(orderType))
            return null;

        return new Order.Builder().setOrderID(orderID)
                .setOrderDetails(orderDetails)
                .setOrderType(orderType)
                .setOrderQuantity(Integer.parseInt(String.valueOf(orderQuantity)))
                .build();
    }




}