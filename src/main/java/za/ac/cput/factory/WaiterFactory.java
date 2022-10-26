package za.ac.cput.factory;

import za.ac.cput.domain.Waiter;
import za.ac.cput.util.GenericHelper;

public class WaiterFactory {
    public static Waiter createWaiter(String waiterID, String firstName, String lastName, String email , String address, String contactNumber ) {

        if (!GenericHelper.isValidEmail(email))
            return null;

        if (GenericHelper.isNullorEmpty(firstName) || GenericHelper.isNullorEmpty(lastName))
            return null;

        return new Waiter.Builder()
                .setWaiterID(waiterID)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setAddress(address)
                .setContactNumber(contactNumber)
                .build();


    }


}
