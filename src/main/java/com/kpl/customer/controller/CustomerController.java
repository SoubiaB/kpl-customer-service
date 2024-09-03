package com.kpl.customer.controller;

import com.kpl.customer.CustomerService;
import com.kpl.customer.model.CustomerDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDetails> createCustomerDetails(@RequestBody  CustomerDetails customerDetails)
    {
        return customerService.saveCustomerDetails(customerDetails);

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CustomerDetails> getCustomerById(@PathVariable String id)
    {
        return customerService.getCustomerById(id);
    }

    @GetMapping("/getAll")
    public List<CustomerDetails> getAllCustomerDetails()
    {
        return customerService.getAllCustomerDetails();
    }

    @PutMapping("/update")
    public ResponseEntity<CustomerDetails> updateCustomerDetails(@RequestBody CustomerDetails customerDetails)
    {
        return customerService.update(customerDetails);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCustomerById(@PathVariable String id)
    {
        return customerService.deleteCustomerById(id);
    }
    @DeleteMapping("/deleteAll")
    public String deleteAll()
    {
      return customerService.deleteAll();
    }
}
