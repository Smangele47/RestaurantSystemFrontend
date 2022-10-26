package za.ac.cput.gui.Tim.Manager;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Manager;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.ManagerFactory;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

public class httpsmethods  {

    //RestTemplate and HTTPHeaders
    private RestTemplate restTemplate = new RestTemplate();
    private HttpHeaders headers = new HttpHeaders();

    //Main Controller Url
    private String MainUrl = "http://localhost:8080/customer";

    //Save Method with parameters
    public void saveManager(String managerID,
                             String firstName,
                             String lastName,
                             String email,
                             String address, String contactNumber ) {

        //Use parameters to build new Item
        Manager manager = ManagerFactory.createManager(managerID,
                firstName, lastName, email, address, contactNumber);

        //Url used to create new Item
        String url = MainUrl + "/create";

        //Applying Password and username to hearders
        headers.setBasicAuth("user", "password");

        //Item as new HttpEntity
        HttpEntity<Manager> httpEntityCreate = new HttpEntity<>(manager, headers);

        //PostForEntity using url to create
        ResponseEntity<Manager> responseCreate = restTemplate.postForEntity(url, httpEntityCreate, Manager.class);

        if (responseCreate.getStatusCode() == HttpStatus.valueOf(200)) {
            JOptionPane.showMessageDialog(null, "Customer Saved");
        } else {
            JOptionPane.showMessageDialog(null, "Customer not Saved");
        }
    }


    //Delete Method with ID parameter
    public void deleteManager(String id){
        Manager m = null;

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
    public Manager findManager(String id){
        Manager m = null;

        //Url used to read Item
        String url = MainUrl+ "/read/"+id;

        //Applying Password and username to headers
        headers.setBasicAuth("user", "password");

        //Item as new HttpEntity
        HttpEntity<Manager> httpEntityRead = new HttpEntity<>(m, headers);

        //PostForEntity using url to read
        ResponseEntity<Manager> responseRead = restTemplate.postForEntity(url, httpEntityRead, Manager.class);

        return responseRead.getBody();
    }


    //Update method with Item Parameter
    public void updateManager(Manager manager){

        //Url used to update Item
        String url =MainUrl +"/update";

        //Applying Password and username to headers
        headers.setBasicAuth("user", "password");

        //Item as new HttpEntity
        HttpEntity<Manager> httpEntityUpdate = new HttpEntity<>(manager, headers);

        //PostForEntity - exchange with Post method
        ResponseEntity<Manager> responseUpdate = restTemplate.exchange(url, HttpMethod.POST, httpEntityUpdate, Manager.class);
    }

    //Get All method with Set Parameter
    public Set<Manager> getManagers(){

        //Create new Set
        Set<Manager> managersSet = new HashSet<>();

        //Create Array
        Manager[] managers;

        //Url used to get All Items
        String url = MainUrl+"/findAll";

        //Applying Password and username to headers
        headers.setBasicAuth("user","password");

        //HttpEntity
        HttpEntity<String> httpEntityGetAll = new HttpEntity<>(null, headers);

        //ResponseEntity - exchange
        ResponseEntity<Manager[]> responseGetAll =restTemplate.exchange(url, HttpMethod.GET, httpEntityGetAll, Manager[].class);

        //Store response body in array
        managers = responseGetAll.getBody();

        //loop through array and add each item into the set
        for (Manager manager : managers){
            managersSet.add(manager);
        }
        return managersSet;
    }


}
