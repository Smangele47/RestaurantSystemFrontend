package za.ac.cput.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/*
    Order.java
    Author: Damone Hartnick 219093717
    Date: October 2022
*/
@Entity
public class Order implements Serializable {

    @NotNull
    @Id
    private String  orderID;
    private String orderDetails;
    private String orderType ;
    @NotNull
    private int orderQuantity;

    protected Order() {}

    private Order(Builder builder){
        this.orderID = builder.orderID;
        this.orderDetails = builder.orderDetails;
        this.orderType = builder.orderType;
        this.orderQuantity = builder.orderQuantity;
    }

    public String getOrderID() {
        return orderID;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public String getOrderType() {
        return orderType;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }



    public static class Builder {
        private String  orderID;
        private String orderDetails;
        private String orderType ;
        private int orderQuantity;

        public Builder setOrderID(String orderID) {
            this.orderID = orderID;
            return this;

        }

        public Builder setOrderDetails(String orderDetails) {
            this.orderDetails = orderDetails;
            return  this;
        }

        public Builder setOrderType(String orderType) {
            this.orderType = orderType;
            return this;

        }

        public Builder setOrderQuantity(int orderQuantity) {
            this.orderQuantity = orderQuantity;
            return this;

        }

        public Builder copy (Order order) {
            this.orderID = order.orderID;
            this.orderDetails = order.orderDetails;
            this.orderType = order.orderType;
            this.orderQuantity = order.orderQuantity;
            return this;
        }

        public Order build(){
            return new Order(this);
        }


    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID='" + orderID + '\'' +
                ", orderDetails='" + orderDetails + '\'' +
                ", orderType='" + orderType + '\'' +
                ", orderQuantity=" + orderQuantity +
                '}';
    }


}
