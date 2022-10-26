package za.ac.cput.domain;
/*
    Delivery.java
    Entity for Delivery
    Author: Jody Heideman (219307725)
    Date: 27/03/2022
 */

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="delivery")
public class Delivery {

    @Id

    private String deliveryID;
    private String deliveryMethod ,deliveryAddress ,deliveryTime;

    private Delivery() {}

    private Delivery(Builder builder){

        this.deliveryID = builder.deliveryID;
        this.deliveryMethod = builder.deliveryMethod;;
        this.deliveryAddress = builder.deliveryAddress;
        this.deliveryTime = builder.deliveryTime;

    }

    public String getDeliveryID() {
        return deliveryID;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public static class Builder{

        private String deliveryID;
        private String deliveryMethod;
        private String deliveryAddress;
        private String deliveryTime;

        public Builder setDeliveryID(String deliveryID){
            this.deliveryID = deliveryID;
            return this;
        }

        public Builder setDeliveryMethod(String deliveryMethod){
            this.deliveryMethod = deliveryMethod;
            return this;
        }

        public Builder setDeliveryAddress(String deliveryAddress){
            this.deliveryAddress = deliveryAddress;
            return this;

        }

        public Builder setDeliveryTime(String deliveryTime){
            this.deliveryTime = deliveryTime;
            return this;
        }

        public Builder copy(Delivery delivery){

            this.deliveryID = delivery.deliveryID;
            this.deliveryMethod = delivery.deliveryMethod;
            this.deliveryAddress = delivery.deliveryAddress;
            this.deliveryTime = delivery.deliveryTime;
            return this;


        }
        public Delivery build(){
            return new Delivery(this);
        }

    }
    @Override
    public String toString() {
        return "Delivery{" +
                "deliveryID = " + deliveryID +
                ", deliveryMethod = '" + deliveryMethod + '\'' +
                ", deliveryAddress = '" + deliveryAddress + '\'' +
                ", deliveryTime = '" + deliveryTime + '\'' +
                '}';
    }
}
