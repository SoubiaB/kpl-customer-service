package com.kpl.customer.repository;

import com.kpl.customer.model.CustomerDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<CustomerDetails,String> {
}
