package com.kpl.customer;

import com.kpl.customer.model.CustomerDetails;
import com.kpl.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {


    @Autowired
    private CustomerRepository customerRepository;

    public ResponseEntity<CustomerDetails> saveCustomerDetails(CustomerDetails customerDetails)
    {
        CustomerDetails savedCustomer = customerRepository.save(customerDetails);
        return ResponseEntity.ok(savedCustomer);
    }

    public ResponseEntity<CustomerDetails> getCustomerById(String id) {
        try {
            if (customerRepository.existsById(id)) {
                return ResponseEntity.ok(customerRepository.findById(id).get());
            }
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<CustomerDetails> update(CustomerDetails customerDetails) {
        try {
            String customerId = customerDetails.getId();
            if(customerId.isEmpty()){
                return ResponseEntity.notFound().build();
            }

            boolean exists=customerRepository.existsById(customerId);
            if(exists){
                return ResponseEntity.ok(customerRepository.save(customerDetails));
            }else{
                return ResponseEntity.notFound().build();
            }

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    public List<CustomerDetails> getAllCustomerDetails() {
        return customerRepository.findAll();
    }

    public String deleteCustomerById(String id) {
        if(customerRepository.existsById(id)){
            customerRepository.deleteById(id);
            return "Customer deleted successfully";
        }
        return "Customer deletion failed";
    }

    public String deleteAll() {
        try{
            customerRepository.deleteAll();
           return "Deletion Successfull";
        } catch (Exception e) {
            return "Deletion Failed";
        }
    }
}
