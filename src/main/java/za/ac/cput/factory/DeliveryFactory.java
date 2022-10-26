package za.ac.cput.factory;
/*
    DeliveryFactory.java
    Entity for DeliveryFactory
    Author: Jody Heideman (219307725)
    Date: 27/03/2022
 */

import za.ac.cput.domain.Delivery;

public class DeliveryFactory {

    public static Delivery createDelivery(String deliveryID , String deliveryMethod , String deliveryAddress , String deliveryTime)
    {
        if(Validation.isEmptyString(deliveryID)) return null;
        if(Validation.isEmptyString(deliveryMethod) ||Validation.isEmptyString(deliveryAddress) || Validation.isEmptyString(deliveryTime))
            return null;

        return new Delivery.Builder()
                .setDeliveryID(deliveryID)
                .setDeliveryMethod(deliveryMethod)
                .setDeliveryAddress(deliveryAddress)
                .setDeliveryTime(deliveryTime)
                .build();


    }
    public static class Validation{

            public static boolean isEmptyString(String s ){
                return s == null  || s.isEmpty() || s.equalsIgnoreCase("null");

            }

            public static boolean isEmptyInt(int i){
                return i == 0;
            }



    }
}
