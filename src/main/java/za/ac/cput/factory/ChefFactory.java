package za.ac.cput.factory;

import za.ac.cput.domain.Chef;
import za.ac.cput.util.GenericHelper;

public class ChefFactory {

    public static Chef createChef(String chefID, String chefName, String chefGender, String chefSalary, String mealStatus){

        if (GenericHelper.isNullorEmpty(chefName) || GenericHelper.isNullorEmpty(chefName))
            return null;
//
        return new Chef.Builder().setChefID(chefID)
                .setChefName(chefName)
                .setChefGender(chefGender)
                .setChefSalary(chefSalary)
                .setMealStatus(mealStatus)
                .build();

    }
}
