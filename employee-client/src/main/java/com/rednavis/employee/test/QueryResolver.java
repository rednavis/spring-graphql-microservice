package com.rednavis.employee.test;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.rednavis.employee.test.customers.Customer;
import com.rednavis.employee.test.customers.data.CustomerModel;
import com.rednavis.employee.test.customers.data.CustomerRepository;
import org.springframework.stereotype.Component;

@Component
public class QueryResolver implements GraphQLQueryResolver {

  private CustomerRepository customerRepository;

  public QueryResolver(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public Customer customerById(Long id) {
    return customerRepository
        .findById(id)
        .map(this::modelToGraphQL)
        .orElse(null);
  }

  private Customer modelToGraphQL(CustomerModel customerModel) {
    Customer customer = new Customer();
    customer.setId(customerModel.getId());
    customer.setName(customerModel.getName());
    customer.setEmail(customerModel.getEmail());

    return customer;
  }
}
