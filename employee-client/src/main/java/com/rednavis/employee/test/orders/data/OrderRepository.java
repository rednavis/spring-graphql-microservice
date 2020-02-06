package com.rednavis.employee.test.orders.data;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderModel, Long> {

  List<OrderModel> findByCustomerId(Long customerId);
}
