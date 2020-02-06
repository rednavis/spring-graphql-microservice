package com.rednavis.employee.test.customers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.rednavis.employee.test.orders.Order;
import com.rednavis.employee.test.orders.data.OrderModel;
import com.rednavis.employee.test.orders.data.OrderRepository;
import com.rednavis.employee.test.products.Product;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerResolver implements GraphQLResolver<Customer> {

  private OrderRepository orderRepository;

  @Autowired
  public CustomerResolver(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  public List<Order> orders(Customer customer) {
    return orderRepository.findByCustomerId(customer.getId())
        .stream()
        .map(this::orderToGraphQL)
        .collect(Collectors.toList());
  }

  private Order orderToGraphQL(OrderModel orderModel) {
    Order order = new Order();
    order.setId(orderModel.getId());
    order.setStatus(orderModel.getStatus());
    order.setQuantity(orderModel.getQuantity());
    order.setCreated(orderModel.getCreated());

    Product product = new Product();
    product.setId(orderModel.getProductId());
    order.setProduct(product);

    Customer customer = new Customer();
    customer.setId(orderModel.getCustomerId());
    order.setCustomer(customer);

    return order;
  }
}
