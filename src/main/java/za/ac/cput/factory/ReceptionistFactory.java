package za.ac.cput.factory;
/*
    ReceptionistFactory.java
    Entity for ReceptionistFactory
    Author: Jody Heideman (219307725)
    Date: 27/03/2022
 */
import za.ac.cput.domain.Receptionist;

public class ReceptionistFactory {

    public static Receptionist createReceptionist(String receptionistID , String receptionistTime , String numberOfPeople , String createReservation)
    {
        if(DeliveryFactory.Validation.isEmptyString(createReservation)) return null;
        if(DeliveryFactory.Validation.isEmptyString(receptionistID) || DeliveryFactory.Validation.isEmptyString(receptionistTime) || DeliveryFactory.Validation.isEmptyString(numberOfPeople))
            return null;

        return new Receptionist.Builder()
                .setReceptionistID(receptionistID)
                .setReceptionistTime(receptionistTime)
                .setNumberOfPeople(numberOfPeople)
                .setCreateReservation(createReservation)
                .build();


    }
}
