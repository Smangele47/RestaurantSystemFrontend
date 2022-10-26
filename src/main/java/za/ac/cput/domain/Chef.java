package za.ac.cput.domain;
/*
    Chef.java
    Author: Smangele Mabaso 220047154
    Date: October 2022
*/
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Chef implements Serializable {
    @NotNull
    @Id
    private String chefID;
    private String chefName, chefGender, mealStatus;
    private String chefSalary;

    private Chef() {
    }

    //Private Constructor
    private Chef(Chef.Builder builder) {

        this.chefID = builder.chefID;
        this.chefName = builder.chefName;
        this.chefGender = builder.chefGender;
        this.chefSalary = builder.chefSalary;
        this.mealStatus = builder.mealStatus;

    }

    //Constructor
    public Chef(String chefID, String chefName, String chefGender, String chefSalary, String mealStatus) {
        this.chefID = chefID;
        this.chefName = chefName;
        this.chefGender = chefGender;
        this.chefSalary = chefSalary;
        this.mealStatus = mealStatus;
    }

    //Getters and Setter
    public String getChefID() {
        return chefID;
    }

    public void setChefID(String chefID) {
        this.chefID = chefID;
    }

    public String getChefName() {
        return chefName;
    }

    public void setChefName(String chefName) {
        this.chefName = chefName;
    }

    public String getChefGender() {
        return chefGender;
    }

    public void setChefGender(String chefGender) {
        this.chefGender = chefGender;
    }

    public String getChefSalary() {
        return chefSalary;
    }

    public void setChefSalary(String chefSalary) {
        this.chefSalary = chefSalary;
    }

    public String getMealStatus() {
        return mealStatus;
    }

    public void setMealStatus(String mealStatus) {
        this.mealStatus = mealStatus;
    }

    @Override
    public String toString() {
        return "Chef{" +
                "chefID='" + chefID + '\'' +
                ", chefName='" + chefName + '\'' +
                ", chefGender='" + chefGender + '\'' +
                ", chefSalary=" + chefSalary +
                ", mealStatus='" + mealStatus + '\'' +
                '}';
    }

    //Builder
    public static class Builder {
        private String chefID;
        private String chefName;
        private String chefGender;
        private String chefSalary;
        private String mealStatus;

        public String getChefID() {
            return chefID;
        }

        public Builder setChefID(String chefID) {
            this.chefID = chefID;
            return this;
        }

        public String getChefName() {
            return chefName;
        }

        public Builder setChefName(String chefName) {
            this.chefName = chefName;
            return this;
        }

        public String getChefGender() {
            return chefGender;
        }

        public Builder setChefGender(String chefGender) {
            this.chefGender = chefGender;
            return this;
        }

        public String getChefSalary() {
            return chefSalary;
        }

        public Builder setChefSalary(String chefSalary) {
            this.chefSalary = chefSalary;
            return this;
        }

        public String getMealStatus() {
            return mealStatus;
        }

        public Builder setMealStatus(String mealStatus) {
            this.mealStatus = mealStatus;
            return this;
        }

        public Chef.Builder copy(Chef chef) {
            this.chefID = chef.chefID;
            this.chefName = chef.chefName;
            this.chefGender = chef.chefGender;
            this.chefSalary = chef.chefSalary;
            this.mealStatus = chef.mealStatus;
            return this;
        }

        public Chef build() {
            return new Chef(this);
        }

    }
}
