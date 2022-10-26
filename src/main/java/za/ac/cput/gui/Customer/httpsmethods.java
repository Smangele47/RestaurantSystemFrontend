package za.ac.cput.gui.Customer;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CustomerFactory;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

public class httpsmethods {

    //RestTemplate and HTTPHeaders
    private RestTemplate restTemplate = new RestTemplate();
    private HttpHeaders headers = new HttpHeaders();

    //Main Controller Url
    private String MainUrl = "http://localhost:8080/customer";

    //Save Method with parameters
    public void saveCustomer(String customerID,
                             String firstName,
                             String lastName,
                             String email,
                             String address, String contactNumber ) {

        //Use parameters to build new Item
        Customer customer = CustomerFactory.createCustomer(customerID,
                firstName, lastName, email, address, contactNumber);

        //Url used to create new Item
        String url = MainUrl + "/create";

        //Applying Password and username to hearders
        headers.setBasicAuth("user", "password");

        //Item as new HttpEntity
        HttpEntity<Customer> httpEntityCreate = new HttpEntity<>(customer, headers);

        //PostForEntity using url to create
        ResponseEntity<Customer> responseCreate = restTemplate.postForEntity(url, httpEntityCreate, Customer.class);

        if (responseCreate.getStatusCode() == HttpStatus.valueOf(200)) {
            JOptionPane.showMessageDialog(null, "Customer Saved");
        } else {
            JOptionPane.showMessageDialog(null, "Customer not Saved");
        }
    }


    //Delete Method with ID parameter
    public void deleteCustomer(String id){
        Customer c = null;

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
    public Customer findCustomer(String id){
        Customer c = null;

        //Url used to read Item
        String url = MainUrl+ "/read/"+id;

        //Applying Password and username to headers
        headers.setBasicAuth("user", "password");

        //Item as new HttpEntity
        HttpEntity<Customer> httpEntityRead = new HttpEntity<>(c, headers);

        //PostForEntity using url to read
        ResponseEntity<Customer> responseRead = restTemplate.postForEntity(url, httpEntityRead, Customer.class);

        return responseRead.getBody();
    }


    //Update method with Item Parameter
    public void updateCustomer(Customer customer){

        //Url used to update Item
        String url =MainUrl +"/update";

        //Applying Password and username to headers
        headers.setBasicAuth("user", "password");

        //Item as new HttpEntity
        HttpEntity<Customer> httpEntityUpdate = new HttpEntity<>(customer, headers);

        //PostForEntity - exchange with Post method
        ResponseEntity<Customer> responseUpdate = restTemplate.exchange(url, HttpMethod.POST, httpEntityUpdate, Customer.class);
    }

    //Get All method with Set Parameter
    public Set<Customer> getCustomers(){

        //Create new Set
        Set<Customer> customersSet = new HashSet<>();

        //Create Array
        Customer[] customers;

        //Url used to get All Items
        String url = MainUrl+"/findAll";

        //Applying Password and username to headers
        headers.setBasicAuth("user","password");

        //HttpEntity
        HttpEntity<String> httpEntityGetAll = new HttpEntity<>(null, headers);

        //ResponseEntity - exchange
        ResponseEntity<Customer[]> responseGetAll =restTemplate.exchange(url, HttpMethod.GET, httpEntityGetAll, Customer[].class);

        //Store response body in array
        customers = responseGetAll.getBody();

        //loop through array and add each item into the set
        for (Customer customer : customers){
            customersSet.add(customer);
        }
        return customersSet;
    }



}
