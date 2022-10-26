package za.ac.cput.domain;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class Manager implements Serializable {

    @NotNull
    @Id
    private String managerID;
    private String firstName;
    private String lastName;

    @NotNull
    private String email;
    private String address;
    private String contactNumber;

    protected Manager(){}


    private Manager(Manager.Builder builder){
        this.managerID = builder.managerID;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.address = builder.address;
        this.contactNumber = builder.contactNumber;

    }

    public  String getManagerID() {
        return managerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getContactNumber() {
        return contactNumber;
    }



    public static class Builder {
        private String managerID;
        private String firstName;
        private String lastName;
        private String email;
        private String address;
        private String contactNumber;

        public Manager.Builder setManagerID(String managerID) {
            this.managerID = managerID;
            return this;
        }

        public Manager.Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Manager.Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Manager.Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Manager.Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Manager.Builder setContactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
            return this;
        }


        public Manager.Builder copy (Manager manager){
            this.managerID = manager.managerID;
            this.firstName = manager.firstName;
            this.lastName = manager.lastName;
            this.email = manager.email;
            this.address = manager.address;
            this.contactNumber = manager.contactNumber;
            return this;
        }

        public Manager build(){
            return new Manager(this);

        }

    }

    @Override
    public String toString() {
        return "Manager{" +
                "managerID='" + managerID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}



