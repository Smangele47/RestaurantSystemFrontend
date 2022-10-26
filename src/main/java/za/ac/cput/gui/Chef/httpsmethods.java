package za.ac.cput.gui.Chef;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.domain.Chef;
import za.ac.cput.factory.ChefFactory;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

public class httpsmethods {

        //RestTemplate and HTTPHeaders
        private RestTemplate restTemplate = new RestTemplate();
        private HttpHeaders headers = new HttpHeaders();

        //Main Controller Url
        private String MainUrl = "http://localhost:8080/chef";

        //Save Method with parameters
        public void saveChef(String ChefID,
                                 String ChefName,
                                 String ChefGender,
                                 String ChefSalary,
                                 String MealStatus) {

            //Use parameters to build new Items
            Chef chef = ChefFactory.createChef( ChefID, ChefName, ChefGender, ChefSalary, MealStatus);

            //Url used to create new Item
            String url = MainUrl + "/create";

            //Applying Password and username to hearders
            headers.setBasicAuth("user", "password");

            //Item as new HttpEntity
            HttpEntity<Chef> httpEntityCreate = new HttpEntity<>(chef, headers);

            //PostForEntity using url to create
            ResponseEntity<Chef> responseCreate = restTemplate.postForEntity(url, httpEntityCreate, Chef.class);

            if (responseCreate.getStatusCode() == HttpStatus.valueOf(200)) {
                JOptionPane.showMessageDialog(null, "Chef Saved");
            } else {
                JOptionPane.showMessageDialog(null, "Chef not Saved");
            }
        }


        //Delete Method with ID parameter
        public void deleteChef(String id){
            Chef c = null;

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
        public Chef findChef(String id){
            Chef c = null;

            //Url used to read Item
            String url = MainUrl+ "/read/"+id;

            //Applying Password and username to headers
            headers.setBasicAuth("user", "password");

            //Item as new HttpEntity
            HttpEntity<Chef> httpEntityRead = new HttpEntity<>(c, headers);

            //PostForEntity using url to read
            ResponseEntity<Chef> responseRead = restTemplate.postForEntity(url, httpEntityRead, Chef.class);

            return responseRead.getBody();
        }


        //Update method with Item Parameter
        public void updateChef(Chef chef){

            //Url used to update Item
            String url =MainUrl +"/update";

            //Applying Password and username to headers
            headers.setBasicAuth("user", "password");

            //Item as new HttpEntity
            HttpEntity<Chef> httpEntityUpdate = new HttpEntity<>(chef, headers);

            //PostForEntity - exchange with Post method
            ResponseEntity<Chef> responseUpdate = restTemplate.exchange(url, HttpMethod.POST, httpEntityUpdate, Chef.class);
        }

        //Get All method with Set Parameter
        public Set<Chef> getChef(){

            //Create new Set
            Set<Chef> chefsSet = new HashSet<>();

            //Create Array
            Chef[] chefs;

            //Url used to get All Items
            String url = MainUrl+"/findAll";

            //Applying Password and username to headers
            headers.setBasicAuth("user","password");

            //HttpEntity
            HttpEntity<String> httpEntityGetAll = new HttpEntity<>(null, headers);

            //ResponseEntity - exchange
            ResponseEntity<Chef[]> responseGetAll =restTemplate.exchange(url, HttpMethod.GET, httpEntityGetAll, Chef[].class);

            //Store response body in array
            chefs = responseGetAll.getBody();

            //loop through array and add each item into the set
            for (Chef chef : chefs){
                chefsSet.add(chef);
            }
            return chefsSet;
        }


    }
