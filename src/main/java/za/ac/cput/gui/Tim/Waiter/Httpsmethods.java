package za.ac.cput.gui.Tim.Waiter;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.domain.Waiter;
import za.ac.cput.factory.WaiterFactory;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

public class Httpsmethods {

    //RestTemplate and HTTPHeaders
    private RestTemplate restTemplate = new RestTemplate();
    private HttpHeaders headers = new HttpHeaders();

    //Main Controller Url
    private String MainUrl = "http://localhost:8080/customer";

    //Save Method with parameters
    public void saveWaiter(String waiterID,
                             String firstName,
                             String lastName,
                             String email,
                             String address, String contactNumber ) {

        //Use parameters to build new Item
        Waiter waiter = WaiterFactory.createWaiter(waiterID,
                firstName, lastName, email, address, contactNumber);

        //Url used to create new Item
        String url = MainUrl + "/create";

        //Applying Password and username to hearders
        headers.setBasicAuth("user", "password");

        //Item as new HttpEntity
        HttpEntity<Waiter> httpEntityCreate = new HttpEntity<>(waiter, headers);

        //PostForEntity using url to create
        ResponseEntity<Waiter> responseCreate = restTemplate.postForEntity(url, httpEntityCreate, Waiter.class);

        if (responseCreate.getStatusCode() == HttpStatus.valueOf(200)) {
            JOptionPane.showMessageDialog(null, "Customer Saved");
        } else {
            JOptionPane.showMessageDialog(null, "Customer not Saved");
        }
    }


    //Delete Method with ID parameter
    public void deleteWaiter(String id){
        Waiter w = null;

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
    public Waiter findWaiter(String id){
        Waiter w = null;

        //Url used to read Item
        String url = MainUrl+ "/read/"+id;

        //Applying Password and username to headers
        headers.setBasicAuth("user", "password");

        //Item as new HttpEntity
        HttpEntity<Waiter> httpEntityRead = new HttpEntity<>(w, headers);

        //PostForEntity using url to read
        ResponseEntity<Waiter> responseRead = restTemplate.postForEntity(url, httpEntityRead, Waiter.class);

        return responseRead.getBody();
    }


    //Update method with Item Parameter
    public void updateWaiter(Waiter waiter){

        //Url used to update Item
        String url =MainUrl +"/update";

        //Applying Password and username to headers
        headers.setBasicAuth("user", "password");

        //Item as new HttpEntity
        HttpEntity<Waiter> httpEntityUpdate = new HttpEntity<>(waiter, headers);

        //PostForEntity - exchange with Post method
        ResponseEntity<Waiter> responseUpdate = restTemplate.exchange(url, HttpMethod.POST, httpEntityUpdate, Waiter.class);
    }

    //Get All method with Set Parameter
    public Set<Waiter> getWaiters(){

        //Create new Set
        Set<Waiter> waitersSet = new HashSet<>();

        //Create Array
        Waiter[] waiters;

        //Url used to get All Items
        String url = MainUrl+"/findAll";

        //Applying Password and username to headers
        headers.setBasicAuth("user","password");

        //HttpEntity
        HttpEntity<String> httpEntityGetAll = new HttpEntity<>(null, headers);

        //ResponseEntity - exchange
        ResponseEntity<Waiter[]> responseGetAll =restTemplate.exchange(url, HttpMethod.GET, httpEntityGetAll, Waiter[].class);

        //Store response body in array
        waiters = responseGetAll.getBody();

        //loop through array and add each item into the set
        for (Waiter waiter : waiters){
            waitersSet.add(waiter);
        }
        return waitersSet;
    }


}
