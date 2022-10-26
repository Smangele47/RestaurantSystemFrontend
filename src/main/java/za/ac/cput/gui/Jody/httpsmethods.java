package za.ac.cput.gui.Jody;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Receptionist;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.ReceptionistFactory;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

public class httpsmethods {

    //RestTemplate and HTTPHeaders
    private RestTemplate restTemplate = new RestTemplate();
    private HttpHeaders headers = new HttpHeaders();

    //Main Controller Url
    private String MainUrl = "http://localhost:8080/receptionist";

    //Save Method with parameters
    public void saveReceptionist(
                             String receptionistID,
                             String receptionistTime,
                             String numberOfPeople,
                             String createReservation) {

        //Use parameters to build new Item
        Receptionist receptionist = ReceptionistFactory.createReceptionist(receptionistID,
                receptionistTime, numberOfPeople, createReservation);

        //Url used to create new Item
        String url = MainUrl + "/create";

        //Applying Password and username to hearders
        headers.setBasicAuth("user", "password");

        //Item as new HttpEntity
        HttpEntity<Receptionist> httpEntityCreate = new HttpEntity<>(receptionist, headers);

        //PostForEntity using url to create
        ResponseEntity<Receptionist> responseCreate = restTemplate.postForEntity(url, httpEntityCreate, Receptionist.class);

        if (responseCreate.getStatusCode() == HttpStatus.valueOf(200)) {
            JOptionPane.showMessageDialog(null, "Receptionist Saved");
        } else {
            JOptionPane.showMessageDialog(null, "Receptionist not Saved");
        }
    }


    //Delete Method with ID parameter
    public void deleteReceptionist(String id){
        Receptionist receptionist = null;

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
    public Receptionist findReceptionist(String id){
        Receptionist receptionist = null;

        //Url used to read Item
        String url = MainUrl+ "/read/"+id;

        //Applying Password and username to headers
        headers.setBasicAuth("user", "password");

        //Item as new HttpEntity
        HttpEntity<Receptionist> httpEntityRead = new HttpEntity<>(receptionist, headers);

        //PostForEntity using url to read
        ResponseEntity<Receptionist> responseRead = restTemplate.postForEntity(url, httpEntityRead, Receptionist.class);

        return responseRead.getBody();
    }


    //Update method with Item Parameter
    public void updateReceptionist(Receptionist receptionist){

        //Url used to update Item
        String url =MainUrl +"/update";

        //Applying Password and username to headers
        headers.setBasicAuth("user", "password");

        //Item as new HttpEntity
        HttpEntity<Receptionist> httpEntityUpdate = new HttpEntity<>(receptionist, headers);

        //PostForEntity - exchange with Post method
        ResponseEntity<Receptionist> responseUpdate = restTemplate.exchange(url, HttpMethod.POST, httpEntityUpdate, Receptionist.class);
    }

    //Get All method with Set Parameter
    public Set<Receptionist> getReceptionist(){

        //Create new Set
        Set<Receptionist> receptionistsSet = new HashSet<>();

        //Create Array
        Receptionist[] receptionists;

        //Url used to get All Items
        String url = MainUrl+"/findAll";

        //Applying Password and username to headers
        headers.setBasicAuth("user","password");

        //HttpEntity
        HttpEntity<String> httpEntityGetAll = new HttpEntity<>(null, headers);

        //ResponseEntity - exchange
        ResponseEntity<Receptionist[]> responseGetAll =restTemplate.exchange(url, HttpMethod.GET, httpEntityGetAll, Receptionist[].class);

        //Store response body in array
        receptionists = responseGetAll.getBody();

        //loop through array and add each item into the set
        for (Receptionist receptionist : receptionists){
            receptionistsSet.add(receptionist);
        }
        return receptionistsSet;
    }


}
