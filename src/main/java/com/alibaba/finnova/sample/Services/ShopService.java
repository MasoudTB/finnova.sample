package com.alibaba.finnova.sample.Services;

import com.alibaba.finnova.sample.Domains.Order;
import com.alibaba.finnova.sample.Domains.User;

public interface ShopService {
    Order createOrder(Long userId, Order order);
    Order checkOrder(Long orderId);
    void removeOrder(Long orderId);

}
