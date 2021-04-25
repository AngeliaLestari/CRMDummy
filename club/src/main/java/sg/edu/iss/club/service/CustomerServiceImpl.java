package sg.edu.iss.club.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.club.domain.Customer;
import sg.edu.iss.club.repo.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository mrepo;

    @Transactional
    public boolean saveCustomer (Customer customer) {
        if (mrepo.save (customer) != null) return true;
        else return false;
    }

    @Transactional
    public ArrayList<Customer> findAllCustomer() {
        return (ArrayList<Customer>) mrepo.findAll();
    }

    @Transactional
    public Customer findCustomerById(Integer id) {
        return mrepo.findById(id).get();
    }

    @Transactional
    public void deleteCustomer(Customer customer) {
        mrepo.delete(customer);
    }




}
