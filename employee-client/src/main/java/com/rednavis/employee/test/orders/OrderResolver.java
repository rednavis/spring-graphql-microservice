package com.rednavis.employee.test.orders;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.rednavis.employee.test.customers.Customer;
import com.rednavis.employee.test.customers.data.CustomerModel;
import com.rednavis.employee.test.customers.data.CustomerRepository;
import com.rednavis.employee.test.products.Product;
import com.rednavis.employee.test.products.data.ProductModel;
import com.rednavis.employee.test.products.data.ProductRepository;
import org.springframework.stereotype.Component;

@Component
public class OrderResolver implements GraphQLResolver<Order> {

  private ProductRepository productRepository;
  private CustomerRepository customerRepository;

  public OrderResolver(ProductRepository productRepository, CustomerRepository customerRepository) {
    this.productRepository = productRepository;
    this.customerRepository = customerRepository;
  }

  public Customer customer(Order order) {
    return customerRepository.findById(order.getCustomer().getId())
        .map(this::modelToGraphQL)
        .orElse(null);
  }

  public Product product(Order order) {
    return productRepository.findById(order.getProduct().getId())
        .map(this::modelToGraphQL)
        .orElse(null);
  }

  private Product modelToGraphQL(ProductModel productModel) {
    Product product = new Product();
    product.setDescription(productModel.getDescription());
    product.setName(productModel.getName());
    product.setId(productModel.getId());
    product.setPrice(productModel.getPrice());
    return product;
  }

  private Customer modelToGraphQL(CustomerModel customerModel) {
    Customer customer = new Customer();
    customer.setEmail(customerModel.getEmail());
    customer.setId(customerModel.getId());
    customer.setName(customerModel.getName());
    return customer;
  }

}
