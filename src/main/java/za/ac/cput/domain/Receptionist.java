package za.ac.cput.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
    Receptionist.java
    Entity for Receptionist
    Author: Jody Heideman (219307725)
    Date: 27/03/2022
 */
@Entity
@Table(name = "receptionist")
public class Receptionist {

    @Id
    private String receptionistID;
    private String receptionistTime;
    private String numberOfPeople;
    private String createReservation;

    private Receptionist(){}
    private Receptionist(Builder builder){

        this.receptionistID = builder.receptionistID;
        this.receptionistTime = builder.receptionistTime;
        this.numberOfPeople = builder.numberOfPeople;
        this.createReservation = builder.createReservation;

    }

    public String getReceptionistID() {
        return receptionistID;
    }

    public void setReceptionistID(String receptionistID) {
        this.receptionistID = receptionistID;
    }

    public String getReceptionistTime() {
        return receptionistTime;
    }

    public void setReceptionistTime(String receptionistTime) {
        this.receptionistTime = receptionistTime;
    }

    public String getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(String numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getCreateReservation() {
        return createReservation;
    }

    public void setCreateReservation(String createReservation) {
        this.createReservation = createReservation;
    }

    @Override
    public String toString() {
        return "Receptionist{ " +
                "receptionistID = " + receptionistID +
                ", receptionistTime = " + receptionistTime +
                ", numberOfPeople = " + numberOfPeople +
                ", createReservation = '" + createReservation + '\'' +
                '}';
    }

    public static class Builder{
        private String receptionistID;
        private String receptionistTime;
        private String numberOfPeople;
        private String createReservation;

        public Builder setReceptionistID(String receptionistID){
            this.receptionistID= receptionistID;
            return this;
        }

        public Builder setReceptionistTime(String receptionistTime){
            this.receptionistTime = receptionistTime;return this;
        }

        public Builder setNumberOfPeople(String numberOfPeople){
            this.numberOfPeople = numberOfPeople;
            return this;
        }

        public Builder setCreateReservation(String createReservation){
            this.createReservation = createReservation;
            return this;
        }

        public Builder copy(Receptionist receptionist){
            this.receptionistID = receptionistID;
            this.receptionistTime = receptionistTime;
            this.numberOfPeople = numberOfPeople;
            this.createReservation = createReservation;
            return this;

        }

        public Receptionist build(){
            return new Receptionist(this);
        }
    }
}
