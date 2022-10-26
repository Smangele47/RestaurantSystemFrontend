package za.ac.cput.gui.Order;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Order;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.OrderFactory;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

public class httpsmethods {

    //RestTemplate and HTTPHeaders
    private RestTemplate restTemplate = new RestTemplate();
    private HttpHeaders headers = new HttpHeaders();

    //Main Controller Url
    private String MainUrl = "http://localhost:8080/order";

    //Save Method with parameters
    public void saveOrder(String orderID,
                             String orderDetails,
                             String orderType,
                             String orderQuantity) {

        //Use parameters to build new Item
        Order order = OrderFactory.createOrder(orderID,
                orderDetails, orderType, Integer.parseInt(orderQuantity));

        //Url used to create new
        String url = MainUrl + "/create";

        //Applying Password and username to hearders
        headers.setBasicAuth("user", "password");

        //Item as new HttpEntity
        HttpEntity<Order> httpEntityCreate = new HttpEntity<>(order, headers);

        //PostForEntity using url to create
        ResponseEntity<Order> responseCreate = restTemplate.postForEntity(url, httpEntityCreate, Order.class);

        if (responseCreate.getStatusCode() == HttpStatus.valueOf(200)) {
            JOptionPane.showMessageDialog(null, "Order Saved");
        } else {
            JOptionPane.showMessageDialog(null, "Order not Saved");
        }
    }

    //Delete Method with ID parameter
    public void deleteOrder(String id){
        Order o = null;

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
    public Order findOrder(String id){
        Order o = null;

        //Url used to read Item
        String url = MainUrl+ "/read/"+id;

        //Applying Password and username to headers
        headers.setBasicAuth("user", "password");

        //Item as new HttpEntity
        HttpEntity<Order> httpEntityRead = new HttpEntity<>(o, headers);

        //PostForEntity using url to read
        ResponseEntity<Order> responseRead = restTemplate.postForEntity(url, httpEntityRead, Order.class);

        return responseRead.getBody();
    }

    //Update method with Item Parameter
    public void updateOrder(Order order){

        //Url used to update Item
        String url =MainUrl +"/update";

        //Applying Password and username to headers
        headers.setBasicAuth("user", "password");

        //Item as new HttpEntity
        HttpEntity<Order> httpEntityUpdate = new HttpEntity<>(order, headers);

        //PostForEntity - exchange with Post method
        ResponseEntity<Order> responseUpdate = restTemplate.exchange(url, HttpMethod.POST, httpEntityUpdate, Order.class);
    }


    //Get All method with Set Parameter
    public Set<Order> getOrders(){

        //Create new Set
        Set<Order> ordersSet = new HashSet<>();

        //Create Array
        Order[] orders;

        //Url used to get All Items
        String url = MainUrl+"/findAll";

        //Applying Password and username to headers
        headers.setBasicAuth("user","password");

        //HttpEntity
        HttpEntity<String> httpEntityGetAll = new HttpEntity<>(null, headers);

        //ResponseEntity - exchange
        ResponseEntity<Order[]> responseGetAll =restTemplate.exchange(url, HttpMethod.GET, httpEntityGetAll, Order[].class);

        //Store response body in array
        orders = responseGetAll.getBody();

        //loop through array and add each item into the set
        for (Order order : orders){
            ordersSet.add(order);
        }
        return ordersSet;
    }







}
