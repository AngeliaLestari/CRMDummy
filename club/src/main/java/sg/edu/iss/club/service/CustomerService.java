package sg.edu.iss.club.service;

import java.util.ArrayList;

import sg.edu.iss.club.domain.Customer;

public interface CustomerService {

    public boolean saveCustomer (Customer customer);

    public ArrayList<Customer> findAllCustomer();

    public Customer findCustomerById(Integer id);

    public void deleteCustomer(Customer customer);

}
