package za.ac.cput.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Waiter implements Serializable {

        @NotNull
        @Id
        private String waiterID;
        private String firstName;
        private String lastName;

        @NotNull
        private String email;
        private String address;
        private String contactNumber;

    protected Waiter(){}


    private Waiter(Builder builder){
            this.waiterID = builder.waiterID;
            this.firstName = builder.firstName;
            this.lastName = builder.lastName;
            this.email = builder.email;
            this.address = builder.address;
            this.contactNumber = builder.contactNumber;

        }

        public  String getWaiterID() {
            return waiterID;
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
            private String waiterID;
            private String firstName;
            private String lastName;
            private String email;
            private String address;
            private String contactNumber;

            public Builder setWaiterID(String waiterID) {
                this.waiterID = waiterID;
                return this;
            }

            public Builder setFirstName(String firstName) {
                this.firstName = firstName;
                return this;
            }

            public Builder setLastName(String lastName) {
                this.lastName = lastName;
                return this;
            }

            public Builder setEmail(String email) {
                this.email = email;
                return this;
            }

            public Builder setAddress(String address) {
                this.address = address;
                return this;
            }

            public Builder setContactNumber(String contactNumber) {
                this.contactNumber = contactNumber;
                return this;
            }


            public Builder copy (Waiter waiter){
                this.waiterID = waiter.waiterID;
                this.firstName = waiter.firstName;
                this.lastName = waiter.lastName;
                this.email = waiter.email;
                this.address = waiter.address;
                this.contactNumber = waiter.contactNumber;
                return this;
            }

            public Waiter build(){
                return new Waiter(this);

            }

        }

        @Override
        public String toString() {
            return "Waiter{" +
                    "waiterID='" + waiterID + '\'' +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", email='" + email + '\'' +
                    ", address='" + address + '\'' +
                    ", contactNumber='" + contactNumber + '\'' +
                    '}';
        }
    }

