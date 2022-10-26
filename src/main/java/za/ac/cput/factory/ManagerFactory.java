package za.ac.cput.factory;

import za.ac.cput.domain.Manager;
import za.ac.cput.util.GenericHelper;

public class ManagerFactory {
    public static Manager createManager(String managerID, String firstName, String lastName, String email, String address, String contactNumber) {

        if (!GenericHelper.isValidEmail(email))
            return null;

        if (GenericHelper.isNullorEmpty(firstName) || GenericHelper.isNullorEmpty(lastName))
            return null;

        return new Manager.Builder()
                .setManagerID(managerID)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setAddress(address)
                .setContactNumber(contactNumber)
                .build();


    }
}