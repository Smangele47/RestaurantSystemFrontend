package za.ac.cput.factory;

import za.ac.cput.domain.Meal;
import za.ac.cput.util.GenericHelper;

public class MealFactory {

    public static Meal createMeal(String mealName, String mealCode, String mealPrice, String takeAway, String mealStatus){
        if (GenericHelper.isNullorEmpty(mealName) || GenericHelper.isNullorEmpty(mealName))
            return null;
        return new Meal.Builder().setMealName(mealName)
                .setMealCode(mealCode)
                .setMealPrice(mealPrice)
                .setTakeAway(takeAway)
                .setMealStatus(mealStatus)
                .build();

    }

}



