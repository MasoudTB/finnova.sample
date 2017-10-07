package com.alibaba.finnova.sample.repositories;

import com.alibaba.finnova.sample.Domains.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    //@Query(value="Select * from test where sdsd = ?1", nativeQuery = true)
    Order findByBuyer(String buyer);
}
