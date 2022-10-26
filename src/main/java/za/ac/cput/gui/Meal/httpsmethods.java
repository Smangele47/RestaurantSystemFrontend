package za.ac.cput.gui.Meal;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.domain.Meal;
import za.ac.cput.factory.MealFactory;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

public class httpsmethods {

        //RestTemplate and HTTPHeaders
        private RestTemplate restTemplate = new RestTemplate();
        private HttpHeaders headers = new HttpHeaders();

        //Main Controller Url
        private String MainUrl = "http://localhost:8080/meal";

        //Save Method with parameters
        public void saveMeal(String MealCode,
                                 String MealName,
                                 String MealPrice,
                                 String MealTakeAway,
                                 String MealStatus) {

            //Use parameters to build new Item
            Meal meal = MealFactory.createMeal( MealCode, MealName, MealPrice, MealTakeAway, MealStatus);

            //Url used to create new Item
            String url = MainUrl + "/create";

            //Applying Password and username to hearders
            headers.setBasicAuth("user", "password");

            //Item as new HttpEntity
            HttpEntity<Meal> httpEntityCreate = new HttpEntity<>(meal, headers);

            //PostForEntity using url to create
            ResponseEntity<Meal> responseCreate = restTemplate.postForEntity(url, httpEntityCreate, Meal.class);

            if (responseCreate.getStatusCode() == HttpStatus.valueOf(200)) {
                JOptionPane.showMessageDialog(null, "Meal Saved");
            } else {
                JOptionPane.showMessageDialog(null, "Meal not Saved");
            }
        }


        //Delete Method with ID parameter
        public void deleteMeal(String id){
            Meal m = null;

            //Url used to delete Item
            String url = MainUrl+ "/delete/"+id;

            //Applying Password and username to headers
            headers.setBasicAuth("user", "password");

            //HTTpEntity with null
            HttpEntity<String> httpEntityDelete = new HttpEntity<>(null, headers);

            //PostForEntity - exchange with Delete method
            ResponseEntity<String> responseDelete = restTemplate.exchange(url, HttpMethod.DELETE, httpEntityDelete, String.class);

        }

        //Find Method with ID parameter
        public Meal findMeal(String id){
            Meal m = null;

            //Url used to read Item
            String url = MainUrl+ "/read/"+id;

            //Applying Password and username to headers
            headers.setBasicAuth("user", "password");

            //Item as new HttpEntity
            HttpEntity<Meal> httpEntityRead = new HttpEntity<>(m, headers);

            //PostForEntity using url to read
            ResponseEntity<Meal> responseRead = restTemplate.postForEntity(url, httpEntityRead, Meal.class);

            return responseRead.getBody();
        }


        //Update method with Item Parameter
        public void updateMeal(Meal meal){

            //Url used to update Item
            String url =MainUrl +"/update";

            //Applying Password and username to headers
            headers.setBasicAuth("user", "password");

            //Item as new HttpEntity
            HttpEntity<Meal> httpEntityUpdate = new HttpEntity<>(meal, headers);

            //PostForEntity - exchange with Post method
            ResponseEntity<Meal> responseUpdate = restTemplate.exchange(url, HttpMethod.POST, httpEntityUpdate, Meal.class);
        }

        //Get All method with Set Parameter
        public Set<Meal> getMeal(){

            //Create new Set
            Set<Meal> mealsSet = new HashSet<>();

            //Create Array
            Meal[] meals;

            //Url used to get All Items
            String url = MainUrl+"/findAll";


            headers.setBasicAuth("user","password");

            //HttpEntity
            HttpEntity<String> httpEntityGetAll = new HttpEntity<>(null, headers);

            //ResponseEntity - exchange
            ResponseEntity<Meal[]> responseGetAll =restTemplate.exchange(url, HttpMethod.GET, httpEntityGetAll, Meal[].class);

            //Store response body in array
            meals = responseGetAll.getBody();

            //loop through array and add each item into the set
            for (Meal meal : meals){
                mealsSet.add(meal);
            }
            return mealsSet;
        }


    }
